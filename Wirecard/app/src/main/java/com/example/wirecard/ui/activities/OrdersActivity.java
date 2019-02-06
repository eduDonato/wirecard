package com.example.wirecard.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.wirecard.R;
import com.example.wirecard.com.ComAPIInterface;
import com.example.wirecard.com.ComAPIService;
import com.example.wirecard.com.model.ResponseInterface;
import com.example.wirecard.com.model.orders.Order;
import com.example.wirecard.com.model.orders.ResponseOrders;
import com.example.wirecard.db.AppPreferenceUtils;
import com.example.wirecard.model.User;
import com.example.wirecard.ui.adapters.OrdersAdapter;
import com.example.wirecard.ui.listener.OnClickDialogListener;
import com.example.wirecard.ui.listener.OrderClickListener;
import com.example.wirecard.utils.AppUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Activity to show the list of orders
 */
public class OrdersActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, ComAPIInterface, OrderClickListener, NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, OnClickDialogListener {

    private static final String TAG = OrdersActivity.class.getSimpleName();

    private OrdersAdapter mOrdersAdapter;
    private ComAPIService service;
    private User mUser;
    private List<Order> mListOrders;

    //UI references
    @BindView(R.id.tv_id_nav)
    TextView tvIdNav;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.rv_orders)
    RecyclerView rvOrders;

    Button btnOpcoesUsuario;
    TextView tvUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        ButterKnife.bind(OrdersActivity.this);

        setSupportActionBar(toolbar);

        initDrawer(toolbar);
        initValues();

        //Execute transaction
        service.getOrders(mUser.getAccessToken(), this);

    }

    /**
     * Initialize side menu
     */
    protected void initDrawer(Toolbar toolbar) {
        Log.d(TAG, "initMenuLateral");

        //Side menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        //NavHeader
        View headerView = navigationView.getHeaderView(0);
        btnOpcoesUsuario = headerView.findViewById(R.id.btnOpcoesUsuario);
        tvUsuario = headerView.findViewById(R.id.tv_usuario);

        btnOpcoesUsuario.setOnClickListener(this);

    }

    /**
     * Initialise values
     */
    private void initValues() {
        //Init order list
        mListOrders = new ArrayList<>();
        //init user logged in
        mUser = getIntent().getExtras().getParcelable(User.KEY_USER);

        //init recycler view
        rvOrders.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //init api service
        service = ComAPIService.getInstance();

        tvUsuario.setText(mUser.getUser());
        tvIdNav.setText(String.format("Account: %s", mUser.getMoipAccount()));
    }

    @Override
    public void onBackPressed() {
        AppUtils.showCustomDialogYesNo("Deseja sair?", this);
    }

    /**
     *
     */
    private void onOpcoesUsuario() {
        Log.d(TAG, "onOpcoesUsuario");

        Context wrapper = new ContextThemeWrapper(this, R.style.PopupMenu);
        PopupMenu popup = new PopupMenu(wrapper, btnOpcoesUsuario);
        try {
            Field[] fields = popup.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popup);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "onOpcoesUsuario: ", e);
        }
        popup.getMenuInflater().inflate(R.menu.menu_user, popup.getMenu());
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }


    private void processResultGetOrders(ResponseOrders c) {
        mListOrders = c.getOrders();
        mOrdersAdapter = new OrdersAdapter(mListOrders, this);
        rvOrders.setAdapter(mOrdersAdapter);
    }


    @Override
    public void onTaskCompleted(ResponseInterface c) {
        processResultGetOrders((ResponseOrders) c);
    }


    @Override
    public void onTaskFailed(Throwable t) {
        AppUtils.showCustomDialogOK("Falha na transação", this);
    }

    @Override
    public void onClickOrder(int index) {
        onCallOrderDetailsActivity(mListOrders.get(index));
    }

    private void onCallOrderDetailsActivity(Order order) {
        Intent intent = new Intent(OrdersActivity.this, DetailsActivity.class);
        intent.putExtra("order_id", order.getId());
        intent.putExtra(User.KEY_USER, mUser);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOpcoesUsuario:
                onOpcoesUsuario();
            default:
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Log.d(TAG, "onMenuItemClick: " + item.getTitle());
        switch (item.getItemId()) {
            case R.id.action_logout:
                onLogout();
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Method for logout actions
     */
    private void onLogout() {
        AppPreferenceUtils.deleteUserData(this);
        onOpenLogin();
    }

    /**
     * Open login activity
     */
    private void onOpenLogin() {
        Intent intent = new Intent(OrdersActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onDialogPositiveClick() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    @Override
    public void onDialogNegativeClick() {

    }
}
