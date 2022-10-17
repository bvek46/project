package com.ocem.getwheels;

import com.ocem.getwheels.Modelresponse.Booking;
import com.ocem.getwheels.Modelresponse.BookingResponse;
import com.ocem.getwheels.Modelresponse.LoginResponse;
import com.ocem.getwheels.Modelresponse.RegisterResponse;
import com.ocem.getwheels.Modelresponse.VehileCategoryResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface api {

    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponse> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("address") String address,
            @Field("password") String password,
            @Field("password_confirmation") String password_confirmation
//            @Field("image") int image
     );

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("vehicle-categories")
    Call<VehileCategoryResponse> getVehicle();

    @POST("booking")
    Call<BookingResponse> requestForBooking(
            @Header("token") String token,
            @Query("from_date") String from_date,
            @Query("to_date") String to_date,
            @Query("address") String address,
            @Query("full_name") String full_name,
            @Query("phone") String phone,
            @Query("email") String email,
            @Query("date_of_birth") String date_of_birth,
            @Query("citizenship_number") String citizenship_number,
            @Query("license_number") String license_number,
            @Query("total") String total,
            @Query("status") String status,
            @Query("user_id") String user_id
    );


}
