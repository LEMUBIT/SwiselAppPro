package com.lemubit.lemuel.swiselapppro.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lemubit.lemuel.swiselapppro.R;
import com.lemubit.lemuel.swiselapppro.adapter.RegisteredCoursesResultsAdapter;
import com.lemubit.lemuel.swiselapppro.model.result.ResultModel;

import org.parceler.Parcels;

public class RegisteredCoursesResultsFragment extends Fragment {
    ResultModel resultModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resultModel = Parcels.unwrap(getArguments().getParcelable("resultModel"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registered_courses_results, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.img_awaiting_result);
        if (resultModel.getData().length > 0) {
            RecyclerView recyclerView = view.findViewById(R.id.rcv_registered_courses_results);
            RegisteredCoursesResultsAdapter registeredCoursesResultsAdapter = new RegisteredCoursesResultsAdapter(resultModel);
            recyclerView.setAdapter(registeredCoursesResultsAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            RecyclerView.ItemDecoration itemDecoration = new
                    DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(itemDecoration);
            imageView.setVisibility(View.INVISIBLE);
        } else {
            imageView.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), "Result Not Yet Out!", Toast.LENGTH_LONG).show();
        }

    }

    public static RegisteredCoursesResultsFragment newInstance(ResultModel resultModel) {
        RegisteredCoursesResultsFragment registeredCoursesResultsFragment = new RegisteredCoursesResultsFragment();
        Bundle args = new Bundle();
        args.putParcelable("resultModel", Parcels.wrap(resultModel));
        registeredCoursesResultsFragment.setArguments(args);
        return registeredCoursesResultsFragment;

    }
}
