package com.lemubit.lemuel.swiselapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lemubit.lemuel.swiselapppro.api.SwiselEndPointCallManager;
import com.lemubit.lemuel.swiselapppro.model.login.LoginModel;
import com.lemubit.lemuel.swiselapppro.ui.HomeActivity;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity {

    EditText etRegNo, etPassword;
    Button btnLogIn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etRegNo = findViewById(R.id.eTxtRegNo);
        etPassword = findViewById(R.id.eTxtPassword);
        btnLogIn = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progressBar);

        //todo continue from here
        btnLogIn.setOnClickListener(v -> {
            String regNo = etRegNo.getText().toString();
            String password = etPassword.getText().toString();
            if (inputValid(regNo, password)) {
                progressBar.setVisibility(View.VISIBLE);
                SwiselEndPointCallManager.loginStudent(regNo, password, new SwiselEndPointCallManager.OnLoginStudentListener() {
                    @Override
                    public void onSuccess(LoginModel loginModel) {
                        progressBar.setVisibility(View.INVISIBLE);
                        if (!loginModel.getStatus().equals("failed")) {
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            intent.putExtra("loginModel", Parcels.wrap(loginModel));
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Check details...", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(MainActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(this, "Please fill all inputs", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public boolean inputValid(String reg, String password) {
        return !TextUtils.isEmpty(reg) && !TextUtils.isEmpty(password);
    }
}
