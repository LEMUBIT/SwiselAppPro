package com.lemubit.lemuel.swiselapppro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemubit.lemuel.swiselapppro.model.result.Data;
import com.lemubit.lemuel.swiselapppro.R;
import com.lemubit.lemuel.swiselapppro.model.result.ResultModel;

public class RegisteredCoursesResultsAdapter extends RecyclerView.Adapter<RegisteredCoursesResultsAdapter.ViewHolder>{

    private ResultModel resultModel;

    public RegisteredCoursesResultsAdapter(ResultModel resultModel) {
        this.resultModel = resultModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View resultView = inflater.inflate(R.layout.item_registered_courses_results, parent, false);
        ViewHolder viewHolder = new ViewHolder(resultView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data[] data = resultModel.getData();
        holder.txtTitle.setText(data[position].getTitle());
        holder.txtCode.setText("("+data[position].getCode()+")");
        holder.txtGrade.setText(data[position].getGrade());
        holder.txtScore.setText("("+data[position].getScore()+")");

    }

    @Override
    public int getItemCount() {
        return resultModel.getData().length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtTitle, txtCode, txtGrade, txtScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle= itemView.findViewById(R.id.txt_result_title);
            txtCode= itemView.findViewById(R.id.txt_result_code);
            txtGrade = itemView.findViewById(R.id.txt_result_grade);
            txtScore= itemView.findViewById(R.id.txt_result_score);

        }
    }
}
