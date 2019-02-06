package com.example.wirecard.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.wirecard.R;
import com.example.wirecard.com.ComAPIInterface;
import com.example.wirecard.com.ComAPIService;
import com.example.wirecard.com.model.ResponseInterface;
import com.example.wirecard.com.model.login.RequestLogin;
import com.example.wirecard.com.model.login.ResponseLogin;
import com.example.wirecard.db.AppPreferenceUtils;
import com.example.wirecard.model.User;
import com.example.wirecard.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A login screen using login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements ComAPIInterface{

    private ComAPIService service;
    private User mUser;

    // UI references
    @BindView(R.id.bt_sign_in)
    Button submitBtn;
    @BindView(R.id.tv_email)
    AutoCompleteTextView tvEmail;
    @BindView(R.id.tv_password)
    EditText tvPassword;
    @BindView(R.id.cl_content)
    ConstraintLayout clContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(LoginActivity.this);
        initValues();

        //tvEmail.addTextChangedListener(TextChangeListener.getListener(tvEmail));
        //tvPassword.addTextChangedListener(TextChangeListener.getListener(tvPassword));
    }
    /**
     * Initialise values
     */
    private void initValues() {
        //Instantiate Service API
        service = ComAPIService.getInstance();

        //Login button listener
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isUserFieldsValid()){
                    mUser = new User(tvEmail.getText().toString(), tvPassword.getText().toString());
                    sendLoginRequest();
                } else {
                    AppUtils.showCustomDialogOK("Dados inválidos!", LoginActivity.this);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        clContent.setVisibility(View.GONE);
        onAutomaticLogin();
    }

    /**
     * Method that check if is possible to login automatically, otherwise show fields
     */
    private void onAutomaticLogin() {
        mUser = AppPreferenceUtils.getUserData(this);
        if(mUser != null &&
                mUser.getPassword() != null &&
                !mUser.getPassword().isEmpty() &&
                mUser.getUser() != null &&
                !mUser.getUser().isEmpty()){

            sendLoginRequest();
        } else {
            clContent.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Check if login fields are valid
     * @return
     */
    private boolean isUserFieldsValid(){
        return !tvEmail.getText().toString().isEmpty() && !tvPassword.getText().toString().isEmpty();
    }

    /**
     * Send login request to API
     */
    public void sendLoginRequest() {
        RequestLogin requestLogin = new RequestLogin();

        requestLogin.setPassword(mUser.getPassword());
        requestLogin.setUsername(mUser.getUser());

        service.login(requestLogin, this);
    }

    @Override
    public void onTaskCompleted(ResponseInterface c) {
        processResultLogin((ResponseLogin) c);
    }

    @Override
    public void onTaskFailed(Throwable t) {
        clContent.setVisibility(View.VISIBLE);
        AppUtils.showCustomDialogOK("Falha na transação", this);
    }

    /**
     * Process the result that came from the transaction
     * @param c
     */
    private void processResultLogin(ResponseLogin responseLogin) {

        mUser.setAccessToken(responseLogin.getAccessToken());
        mUser.setId(responseLogin.getMoipAccount().getId());
        saveData();
        onCallOrdersActivity();
    }

    /**
     * Save user data for future using
     */
    private void saveData() {
        AppPreferenceUtils.setUserData(this, mUser);
    }

    /**
     * Call Orders activity
     */
    private void onCallOrdersActivity() {
        Intent intent = new Intent(LoginActivity.this, OrdersActivity.class);
        intent.putExtra(User.KEY_USER, mUser);
        startActivity(intent);
        finish();
    }
}

