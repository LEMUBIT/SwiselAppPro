package com.lemubit.lemuel.swiselapppro.api;

import com.lemubit.lemuel.swiselapppro.model.transactions.TransactionsModel;
import com.lemubit.lemuel.swiselapppro.model.registeredcourses.RegisteredCoursesModel;
import com.lemubit.lemuel.swiselapppro.model.currentsession.CurrentSessionModel;
import com.lemubit.lemuel.swiselapppro.model.account.AccountDetailModel;
import com.lemubit.lemuel.swiselapppro.model.login.LoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SwiselEndPointCallManager {
    private static SwiselAppEndPoints swiselAppEndPoints = new SwiselApiClient().getSwiselAppEndPoints();

    public static void loginStudent(String regNo, String password, final OnLoginStudentListener listener) {
        final Call<LoginModel> loginModelCall = swiselAppEndPoints.loginUser(Headers.contentType(), regNo, password);

        loginModelCall.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
    }

    public static void getAccountDetails(String id, OnGetAccountDetailsListener onGetAccountDetailsListener) {
        Call<AccountDetailModel> accountDetailModelCall = swiselAppEndPoints.getAccountDetails(Headers.contentType(), id);

        accountDetailModelCall.enqueue(new Callback<AccountDetailModel>() {
            @Override
            public void onResponse(Call<AccountDetailModel> call, Response<AccountDetailModel> response) {
                onGetAccountDetailsListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<AccountDetailModel> call, Throwable t) {
                onGetAccountDetailsListener.onFailure(t.getMessage());
            }
        });
    }

    public static void getCurrentSession(OnGetCurrentSessionListener onGetCurrentSessionListener) {
        Call<CurrentSessionModel> currentSessionModelCall = swiselAppEndPoints.getSessionDetails(Headers.contentType());

        currentSessionModelCall.enqueue(new Callback<CurrentSessionModel>() {
            @Override
            public void onResponse(Call<CurrentSessionModel> call, Response<CurrentSessionModel> response) {
                onGetCurrentSessionListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<CurrentSessionModel> call, Throwable t) {
                onGetCurrentSessionListener.onFailure(t.getMessage());
            }
        });
    }

    public static void getRegisteredCourses(String session, String id, OnGetRegisteredCoursesListener onGetRegisteredCoursesListener) {
        Call<RegisteredCoursesModel> registeredCoursesModelCall = swiselAppEndPoints.getRegisteredCourses(Headers.contentType(), session, id);

        registeredCoursesModelCall.enqueue(new Callback<RegisteredCoursesModel>() {
            @Override
            public void onResponse(Call<RegisteredCoursesModel> call, Response<RegisteredCoursesModel> response) {
                onGetRegisteredCoursesListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<RegisteredCoursesModel> call, Throwable t) {
                onGetRegisteredCoursesListener.onFailure(t.getMessage());
            }
        });
    }

    public static void getTransactionHistory(String id, OnGetTransactionHistoryListener onGetTransactionHistoryListener) {
        Call<TransactionsModel> transactionsModelCall = swiselAppEndPoints.getTransactionHistory(Headers.contentType(), id);

        transactionsModelCall.enqueue(new Callback<TransactionsModel>() {
            @Override
            public void onResponse(Call<TransactionsModel> call, Response<TransactionsModel> response) {
                onGetTransactionHistoryListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<TransactionsModel> call, Throwable t) {
                onGetTransactionHistoryListener.onFailure(t.getMessage());
            }
        });
    }


    public interface OnLoginStudentListener {
        void onSuccess(LoginModel loginModel);

        void onFailure(String errorMessage);
    }

    public interface OnGetAccountDetailsListener {
        void onSuccess(AccountDetailModel accountDetailModel);

        void onFailure(String errorMessage);
    }

    public interface OnGetCurrentSessionListener {
        void onSuccess(CurrentSessionModel currentSessionModel);

        void onFailure(String errorMessage);
    }

    public interface OnGetRegisteredCoursesListener {
        void onSuccess(RegisteredCoursesModel registeredCoursesModel);

        void onFailure(String errorMessage);
    }

    public interface OnGetTransactionHistoryListener {
        void onSuccess(TransactionsModel transactionsModel);

        void onFailure(String errorMessage);
    }


}
