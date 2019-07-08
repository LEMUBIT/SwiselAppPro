package com.lemubit.lemuel.swiselapppro.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lemubit.lemuel.swiselapppro.R;
import com.lemubit.lemuel.swiselapppro.api.SwiselEndPointCallManager;
import com.lemubit.lemuel.swiselapppro.model.account.AccountDetailModel;
import com.lemubit.lemuel.swiselapppro.model.login.LoginModel;

import org.parceler.Parcels;

public class StudentHomeProfileFragment extends Fragment {
    LoginModel loginModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginModel = Parcels.unwrap(getArguments().getParcelable("loginModel"));
        Toast.makeText(getContext(), loginModel.getData().getFirstname(), Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_home_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.img_student_home);

        if (loginModel.getData().getGender().equalsIgnoreCase("male")) {
            imageView.setImageResource(R.drawable.ic_user_male);
        } else {
            imageView.setImageResource(R.drawable.ic_user_female);
        }

        TextView txtStudentId = view.findViewById(R.id.txt_userId);
        TextView txtStudentAccount = view.findViewById(R.id.txt_account);
        TextView txtFirstName = view.findViewById(R.id.txt_userFirstName);
        TextView txtEmail = view.findViewById(R.id.txt_userEmail);
        TextView txtStudentType = view.findViewById(R.id.txt_studentType);
        TextView txtProgramme = view.findViewById(R.id.txt_studentProgramme);
        TextView txtPhone = view.findViewById(R.id.txt_userPhone);

        txtStudentId.setText(loginModel.getData().getStudent_id());
        String name = loginModel.getData().getFirstname() + " " + loginModel.getData().getSurname();
        txtFirstName.setText(name);
        txtEmail.setText(loginModel.getData().getEmail());
        txtStudentType.setText(loginModel.getData().getStudent_type());
        txtProgramme.setText(loginModel.getData().getProgramme());
        txtPhone.setText(loginModel.getData().getMobile());

        SwiselEndPointCallManager.getAccountDetails(loginModel.getData().id, new SwiselEndPointCallManager.OnGetAccountDetailsListener() {
            @Override
            public void onSuccess(AccountDetailModel accountDetailModel) {
                txtStudentAccount.setText(accountDetailModel.data.amount);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });

    }

    public static StudentHomeProfileFragment newInstance(LoginModel loginModel) {
        StudentHomeProfileFragment studentHomeProfile = new StudentHomeProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable("loginModel", Parcels.wrap(loginModel));
        studentHomeProfile.setArguments(args);
        return studentHomeProfile;
    }
}
