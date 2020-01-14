package com.lemubit.lemuel.swiselapppro.api;

import com.lemubit.lemuel.swiselapppro.model.NoticeModel;
import com.lemubit.lemuel.swiselapppro.model.result.ResultModel;
import com.lemubit.lemuel.swiselapppro.model.transactions.TransactionsModel;
import com.lemubit.lemuel.swiselapppro.model.registeredcourses.RegisteredCoursesModel;
import com.lemubit.lemuel.swiselapppro.model.currentsession.CurrentSessionModel;
import com.lemubit.lemuel.swiselapppro.model.account.AccountDetailModel;
import com.lemubit.lemuel.swiselapppro.model.login.LoginModel;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SwiselAppEndPoints {
    @POST("login")
    Call<LoginModel> loginUser(@Header("Content-Type") String contentType, @Query("reg_no") String regNo, @Query("password") String password);

    @POST("account")
    Call<AccountDetailModel> getAccountDetails(@Header("Content-Type") String contentType, @Query("student") String id);

    @POST("current_session")
    Call<CurrentSessionModel> getSessionDetails(@Header("Content-Type") String contentType);

    @POST("registered_courses")
    Call<RegisteredCoursesModel> getRegisteredCourses(@Header("Content-Type") String contentType, @Query("session") String session, @Query("student") String id);

    @POST("transactions")
    Call<TransactionsModel> getTransactionHistory(@Header("Content-Type") String contentType,@Query("student") String id );

    @POST("registered_results")
    Call<ResultModel> getRegisteredResults(@Header("Content-Type") String contentType, @Query("student") String id,@Query("session") String session );

    @POST("notices")
    Call<NoticeModel> getNotifications(@Header("Content-Type") String contentType, @Query("department") String department, @Query("faculty") String faculty);
}
