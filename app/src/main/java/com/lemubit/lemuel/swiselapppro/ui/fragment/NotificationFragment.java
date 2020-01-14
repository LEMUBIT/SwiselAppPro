package com.lemubit.lemuel.swiselapppro.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lemubit.lemuel.swiselapppro.R;
import com.lemubit.lemuel.swiselapppro.adapter.NotificationAdapter;
import com.lemubit.lemuel.swiselapppro.model.NoticeModel;

import org.parceler.Parcel;
import org.parceler.Parcels;

public class NotificationFragment extends Fragment {
    NoticeModel noticeModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noticeModel= Parcels.unwrap(getArguments().getParcelable("notices"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.rcv_notifications);
        NotificationAdapter notificationAdapter = new NotificationAdapter(noticeModel);
        recyclerView.setAdapter(notificationAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    public static NotificationFragment newInstance(NoticeModel noticeModel) {
        NotificationFragment notificationFragment = new NotificationFragment();
        Bundle args = new Bundle();
        args.putParcelable("notices", Parcels.wrap(noticeModel));
        notificationFragment.setArguments(args);
        return notificationFragment;

    }
}
