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
import com.lemubit.lemuel.swiselapppro.adapter.RegisteredCoursesAdapter;
import com.lemubit.lemuel.swiselapppro.model.registeredcourses.RegisteredCoursesModel;

import org.parceler.Parcels;

public class RegisteredCoursesFragment extends Fragment {
RegisteredCoursesModel mRegisteredCoursesModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRegisteredCoursesModel = Parcels.unwrap(getArguments().getParcelable("registeredCourseModel"));
       }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_registered_courses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rcv_registered_courses);
        RegisteredCoursesAdapter registeredCoursesAdapter = new RegisteredCoursesAdapter(mRegisteredCoursesModel);
        recyclerView.setAdapter(registeredCoursesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

    }

    public static RegisteredCoursesFragment newInstance(RegisteredCoursesModel registeredCoursesModel) {
        RegisteredCoursesFragment registeredCourses = new RegisteredCoursesFragment();
        Bundle args = new Bundle();
        args.putParcelable("registeredCourseModel", Parcels.wrap(registeredCoursesModel));
        registeredCourses.setArguments(args);
        return registeredCourses;
    }
}
