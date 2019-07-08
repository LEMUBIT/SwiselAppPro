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
import com.lemubit.lemuel.swiselapppro.adapter.TransactionHistoryAdapter;
import com.lemubit.lemuel.swiselapppro.model.transactions.TransactionsModel;

import org.parceler.Parcels;

public class TransactionsFragment extends Fragment {
TransactionsModel mTransactionsModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTransactionsModel = Parcels.unwrap(getArguments().getParcelable("transactionModel"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transactions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rcv_transactions);
        TransactionHistoryAdapter transactionHistoryAdapter = new TransactionHistoryAdapter(mTransactionsModel);
        recyclerView.setAdapter(transactionHistoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

    }

    public static TransactionsFragment newInstance(TransactionsModel transactionsModel) {
        TransactionsFragment transactionsFragment = new TransactionsFragment();
        Bundle args = new Bundle();
        args.putParcelable("transactionModel", Parcels.wrap(transactionsModel));
        transactionsFragment.setArguments(args);
        return transactionsFragment;
    }
}
