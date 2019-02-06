package com.example.wirecard.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wirecard.R;
import com.example.wirecard.com.model.orders.Order;
import com.example.wirecard.ui.listener.OrderClickListener;
import com.example.wirecard.utils.AppUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.RecyclerViewHolder>
        implements View.OnClickListener {

    private List<Order> orders;
    private OrderClickListener listener;
    private Context con;

    public OrdersAdapter(List<Order> orders, Context con) {
        this.orders = orders;
        this.listener = (OrderClickListener) con;
        this.con = con;
        setHasStableIds(true);

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new RecyclerViewHolder(inflater.inflate(R.layout.list_item_order, parent,
                false));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.tvTotalAmount.setText(AppUtils.formatMoney(holder.itemView.getContext().getString(R.string.braz_coin), order.getAmount().getTotal()));
        holder.tvEmail.setText(order.getCustomer().getEmail());
        holder.tvOwnId.setText(String.format("Sandbox: %s", order.getOwnId()));
        holder.tvDate.setText(AppUtils.getData("yyyy-MM-dd'T'hh:mm:ss", "dd/MM/yyyy",order.getUpdatedAt()));
        holder.clOrder.setOnClickListener(this);
        holder.clOrder.setTag(position);

        if(order.getStatus().compareTo("PAID") == 0){
            holder.ivStatus.setImageDrawable(con.getDrawable(R.drawable.icon_paid));
        } else if(order.getStatus().compareTo("WAITING") == 0){
            holder.ivStatus.setImageDrawable(con.getDrawable(R.drawable.icon_waiting));
        } else if(order.getStatus().compareTo("REVERTED") == 0) {
            holder.ivStatus.setImageDrawable(con.getDrawable(R.drawable.icon_not_paid));
        }

        if(order.getPayments().get(0).getFundingInstrument().getMethod().compareTo("CREDIT_CARD") == 0){
            holder.ivIcon.setImageDrawable(con.getDrawable(R.drawable.ic_credit_card_black_24dp));
        } else if(order.getPayments().get(0).getFundingInstrument().getMethod().compareTo("BOLETO") == 0) {
            holder.ivIcon.setImageDrawable(con.getDrawable(R.drawable.ic_product_barcode));
        }

    }

    @Override
    public int getItemCount() {
        return orders != null ? orders.size() : 0;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClickOrder((Integer) v.getTag());
        }
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_total_amount)
        TextView tvTotalAmount;
        @BindView(R.id.tv_buyer_email)
        TextView tvEmail;
        @BindView(R.id.tv_own_id)
        TextView tvOwnId;
        @BindView(R.id.tv_creation_date)
        TextView tvDate;
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.iv_current_status)
        ImageView ivStatus;
        @BindView(R.id.cl_Order)
        ConstraintLayout clOrder;

        RecyclerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
