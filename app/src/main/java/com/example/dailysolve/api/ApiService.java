package com.example.dailysolve.api;

import com.example.dailysolve.model.Report;
import com.example.dailysolve.model.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface ApiService {

    @GET("get_reports.php")
    Call<List<Report>> getReports();

    @FormUrlEncoded
    @POST("add_report.php")
    Call<ResponseModel> addReport(
            @Field("title") String title,
            @Field("description") String description,
            @Field("category") String category
    );

    @POST("update_report.php")
    Call<ResponseModel> updateReport(@Body Report report);


    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseModel> registerUser(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseModel> loginUser(
            @Field("username_email") String usernameEmail,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("delete_report.php")
    Call<ResponseModel> deleteReport(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("update_report.php")
    Call<ResponseModel> updateReport(

            @Field("id") int id,

            @Field("title") String title,

            @Field("description") String description,

            @Field("category") String category

    );
}