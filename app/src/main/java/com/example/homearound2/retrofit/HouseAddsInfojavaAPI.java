package com.example.homearound2.retrofit;

import com.example.homearound2.DataList1;
import com.example.homearound2.rentmodel.HouseAddsInfo;
import com.example.homearound2.rentmodel.HouseAddsInfo;
import com.example.homearound2.rentmodel.UniqueEmailAddressValidationResponce;
import com.example.homearound2.rentmodel.UserRegistrationInfo;
import com.example.homearound2.rentmodel.ValidateEmailAddress;
//import com.example.homearound2.rentmodel.UserRegistrationInfo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Part;

public interface HouseAddsInfojavaAPI {
    @GET("/houseaddsinfo/get-all")
    Call<List<HouseAddsInfo>> getallHouses();

    //@GET("/houseaddsinfo/getfromsearch?housePlace= ")
    //Call<List<HouseAddsInfo>> getallfromfilter(@Query("housePlace") String housePlace);

    @GET("/houseaddsinfo/get-housedetails")
    Call<HouseAddsInfo> gethouseDetails();  //get only one

    @POST("/houseaddsinfo/save")  //Api.php?apicall=images
    //fun uploadImage(
    //        @retrofit2.http.Part image: MultipartBody.Part, //which is right? Multipart.Part or retrofit2.http.Part
    //        @retrofit2.http.Part("desc")desc:RequestBody
    //): Call<HouseAddsInfo>
    //@NotNull Object upload(@NotNull String image1);
    Call<HouseAddsInfo> save(@Body HouseAddsInfo houseaddsInfo);



    //@POST ("/userregistrationinfo/validate-unique-email")
    //Response<UniqueEmailAddressValidationResponce> validateEmailAddress();  //for email uniqueness validation

    @POST("/userregistrationinfo/validate-unique-email")
    public default Call<UniqueEmailAddressValidationResponce> validateEmailAddress(@Body ValidateEmailAddress body) {
        return validateEmailAddress(body);
    }

    @POST ("/userregistrationinfo/saveuser")
    Call<UserRegistrationInfo> save(@Body  UserRegistrationInfo userregistrationinfo);

    //@PUT("/houseaddsinfo/{id}")
    //Call<HouseAddsInfo> update(@Path ("id") int id, @Body HouseAddsInfo houseaddsInfo);

    @DELETE("/houseaddsinfo/delete")
    Call<HouseAddsInfo> delete(@Body HouseAddsInfo houseaddsInfo);


}
