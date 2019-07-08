package com.lemubit.lemuel.swiselapppro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemubit.lemuel.swiselapppro.R;
import com.lemubit.lemuel.swiselapppro.model.transactions.Data;
import com.lemubit.lemuel.swiselapppro.model.transactions.TransactionsModel;

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder> {
   private TransactionsModel transactionsModel;

    public TransactionHistoryAdapter(TransactionsModel transactionsModel) {
        this.transactionsModel = transactionsModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View courseView = inflater.inflate(R.layout.item_transaction_history, parent, false);
        ViewHolder viewHolder = new ViewHolder(courseView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data[] data = transactionsModel.data;
        holder.txtDate.setText(data[position].getCreated());
        holder.txtAmount.setText(data[position].getAmount());
        holder.txtDescription.setText(data[position].getDescription());
        holder.txtReference.setText("Ref: "+data[position].getReference());
    }

    @Override
    public int getItemCount() {
        return transactionsModel.data.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDate;
        TextView txtAmount;
        TextView txtDescription;
        TextView txtReference;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDate = itemView.findViewById(R.id.txt_date_created);
            txtAmount = itemView.findViewById(R.id.txt_amount);
            txtDescription = itemView.findViewById(R.id.txt_description);
            txtReference = itemView.findViewById(R.id.txt_reference);
        }
    }

}
