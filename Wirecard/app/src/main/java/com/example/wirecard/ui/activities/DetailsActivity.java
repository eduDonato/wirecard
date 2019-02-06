package com.example.wirecard.ui.activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wirecard.R;
import com.example.wirecard.com.ComAPIInterface;
import com.example.wirecard.com.ComAPIService;
import com.example.wirecard.com.model.ResponseInterface;
import com.example.wirecard.com.model.details.ResponseOrderDetails;
import com.example.wirecard.model.User;
import com.example.wirecard.utils.AppUtils;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Activity that show the details of an order
 */
public class DetailsActivity extends AppCompatActivity implements ComAPIInterface {

    //UI references
    private ComAPIService service;
    private String mOrderId;
    private User mUser;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_total_amount)
    TextView tvTotalAmount;
    @BindView(R.id.tv_own_id)
    TextView tvOwnId;
    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_operation_type)
    TextView tvOperationType;
    @BindView(R.id.tv_buyer_name)
    TextView tvBuyerName;
    @BindView(R.id.tv_buyer_email)
    TextView tvBuyerEmail;
    @BindView(R.id.tv_creation_date)
    TextView tvCreationDate;
    @BindView(R.id.iv_current_status)
    ImageView ivCurrentStatus;
    @BindView(R.id.tv_current_status_date)
    TextView tvCurrentStatusDate;
    @BindView(R.id.tv_resume_total_amount)
    TextView tvResumeTotalAmount;
    @BindView(R.id.tv_resume_taxes)
    TextView tvResumeTaxes;
    @BindView(R.id.tv_resume_liquid)
    TextView tvResumeLiquid;
    @BindView(R.id.tv_number_payments)
    TextView tvNumberPayments;
    @BindView(R.id.cl_contentDetails)
    ConstraintLayout clContentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(DetailsActivity.this);
        setSupportActionBar(toolbar);
        initValues();
        service.getOrderDetails(mUser.getAccessToken(), this, mOrderId);
    }

    /**
     * Initialise values
     */
    private void initValues() {
        clContentDetails.setVisibility(View.GONE);
        //init user logged in
        mUser = getIntent().getExtras().getParcelable(User.KEY_USER);
        //init order id
        mOrderId = getIntent().getExtras().getString("order_id");
        //init api service
        service = ComAPIService.getInstance();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * Process the result that came from the transaction
     * @param c
     */
    private void processResultOrderDetails(ResponseOrderDetails c) {
        if(c != null){
            tvTotalAmount.setText(AppUtils.formatMoney("R$", c.getAmount().getTotal()));
            tvOwnId.setText(c.getOwnId());
            tvId.setText(c.getId());
            tvOperationType.setText(c.getPayments().get(0).getFundingInstrument().getMethod());
            tvBuyerName.setText(c.getCustomer().getFullname());
            tvBuyerEmail.setText(c.getCustomer().getEmail());
            tvCreationDate.setText(AppUtils.getData("yyyy-MM-dd'T'hh:mm:ss", "dd/MM/yyyy",c.getCreatedAt()));

            if(c.getStatus().compareTo("PAID") == 0){
                ivCurrentStatus.setImageDrawable(getDrawable(R.drawable.icon_paid));
            } else if(c.getStatus().compareTo("WAITING") == 0){
                ivCurrentStatus.setImageDrawable(getDrawable(R.drawable.icon_waiting));
            } else if(c.getStatus().compareTo("REVERTED") == 0) {
                ivCurrentStatus.setImageDrawable(getDrawable(R.drawable.icon_not_paid));
            }

            tvCurrentStatusDate.setText(AppUtils.getData("yyyy-MM-dd'T'hh:mm:ss", "dd/MM/yyyy",c.getUpdatedAt()));
            tvResumeTotalAmount.setText(AppUtils.formatMoney("R$", c.getAmount().getTotal()));
            tvResumeTaxes.setText(AppUtils.formatMoney("R$", c.getAmount().getFees()));

            BigDecimal total = BigDecimal.valueOf(c.getAmount().getTotal());
            BigDecimal fees = BigDecimal.valueOf(c.getAmount().getFees());
            BigDecimal liquid = total.subtract(fees);

            tvResumeLiquid.setText(AppUtils.formatMoney("R$", liquid.doubleValue()));
            tvNumberPayments.setText(String.valueOf(c.getPayments().size()));
        }
    }

    @Override
    public void onTaskCompleted(ResponseInterface c) {
        processResultOrderDetails((ResponseOrderDetails) c);
        clContentDetails.setVisibility(View.VISIBLE);
    }

    @Override
    public void onTaskFailed(Throwable t) {
        Log.i("TAG", "getListener");
        clContentDetails.setVisibility(View.GONE);
        AppUtils.showCustomDialogOK("Falha na transação", this);
    }
}
