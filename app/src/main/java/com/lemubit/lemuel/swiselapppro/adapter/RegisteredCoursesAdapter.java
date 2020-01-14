package com.lemubit.lemuel.swiselapppro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemubit.lemuel.swiselapppro.R;
import com.lemubit.lemuel.swiselapppro.model.registeredcourses.Data;
import com.lemubit.lemuel.swiselapppro.model.registeredcourses.RegisteredCoursesModel;

public class RegisteredCoursesAdapter extends RecyclerView.Adapter<RegisteredCoursesAdapter.ViewHolder> {
    private RegisteredCoursesModel mRegisteredCoursesModel;

    public RegisteredCoursesAdapter(RegisteredCoursesModel registeredCoursesModel) {
        mRegisteredCoursesModel = registeredCoursesModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View courseView = inflater.inflate(R.layout.item_registered_courses, parent, false);
        ViewHolder viewHolder = new ViewHolder(courseView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data[] data = mRegisteredCoursesModel.getData();
        holder.txtCourseTitle.setText("Course: " + data[position].getTitle());
        holder.txtCourseCode.setText("Code: " + data[position].getCode());
        holder.txtCourseCredit.setText("CL: " + data[position].getCredit());
        holder.txtCurrentSemester.setText(getSemester(data[position].getSemester()));
        holder.txtCourseLevel.setText("Level: " + getLevel(data[position].getLevel()));

    }

    @Override
    public int getItemCount() {
        return mRegisteredCoursesModel.getData().length;
    }

    private String getSemester(String number) {
        if (number.equals("1")) {
            return "S1";
        } else {
            return "S2";
        }
    }

    private String getLevel(String number) {
        //according to current API 1 is for 100 level and 2 for 200 level
        int value = Integer.valueOf(number);
        int level = value * 100;
        return String.valueOf(level);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCourseTitle;
        TextView txtCourseCode;
        TextView txtCourseCredit;
        TextView txtCourseLevel;
        TextView txtCurrentSemester;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCourseTitle = itemView.findViewById(R.id.txt_course_title);
            txtCourseCode = itemView.findViewById(R.id.txt_course_code);
            txtCourseCredit = itemView.findViewById(R.id.txt_credit_load);
            txtCourseLevel = itemView.findViewById(R.id.txt_course_level);
            txtCurrentSemester = itemView.findViewById(R.id.txt_current_semester);
        }
    }

}
