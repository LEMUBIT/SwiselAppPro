package com.lemubit.lemuel.swiselapppro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemubit.lemuel.swiselapppro.R;
import com.lemubit.lemuel.swiselapppro.model.Data;
import com.lemubit.lemuel.swiselapppro.model.NoticeModel;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    private NoticeModel noticeModel;

    public NotificationAdapter(NoticeModel noticeModel) {
        this.noticeModel = noticeModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View noticeView = inflater.inflate(R.layout.item_notification, parent, false);
        ViewHolder viewHolder = new ViewHolder(noticeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data[] data = noticeModel.getData();
        holder.title.setText(data[position].getTitle());
        holder.date.setText(data[position].getCreated());
    }

    @Override
    public int getItemCount() {
        return noticeModel.getData().length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_notification_title);
            date = itemView.findViewById(R.id.txt_notification_date);
        }
    }
}
