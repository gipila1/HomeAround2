package com.example.homearound2.retrofit

import com.example.homearound2.rentmodel.HouseAddsInfo
import com.example.homearound2.rentmodel.UniqueEmailAddressValidationResponce
import com.example.homearound2.rentmodel.UserRegistrationInfo
import com.example.homearound2.rentmodel.ValidateEmailAddress
//import com.example.homearound2.rentmodel.UserRegistrationInfo
//import com.example.homearound2.rentmodel.ValidateEmailAddress
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
//import retrofit2.http.Part

interface HouseAddsInfoAPI {
    @GET("/houseaddsinfo/get-all")
    open fun getallHouses(): Call<List<HouseAddsInfo>>
    val allHouses: Call<List<HouseAddsInfo>>

    //@GET("/houseaddsinfo/getfromsearch")
    //fun getallfromfilter(@Query("housePlace") searchText: String): Call<List<HouseAddsInfo>>  // or searchText : TextInputEditText
    //val allfromfilter: Call<List<HouseAddsInfo>>

    //@GET("/houseaddsinfo/get-housedetails")
    //open fun gethouseDetails(): Call<HouseAddsInfo?>? //get only one
    //val house: Call<HouseAddsInfo>

    //@Multipart
    @POST("/houseaddsinfo/save")
    fun save(@Body houseaddsInfo: HouseAddsInfo): Call<HouseAddsInfo>
    /*fun uploadImage(
        @retrofit2.http.Part image: MultipartBody.Part, //which is right? Multipart.Part or retrofit2.http.Part
        @retrofit2.http.Part("desc") desc: RequestBody
    ) : Call<HouseAddsInfo>*/

    //Here we use suspend fun for coroutines
    @POST ("/userregistrationinfo/validate-unique-email")
    suspend fun validateemailEmailAddress(@Body body: ValidateEmailAddress): Response<UniqueEmailAddressValidationResponce>

    @POST ("/userregistrationinfo/saveuser")
    fun save(@Body userregistrationinfo: UserRegistrationInfo): Call<UserRegistrationInfo>

    //@PUT("/houseaddsinfo/{id}")
    //fun update(@Path("id") id: Int, @Body houseaddsInfo: HouseAddsInfo?): Call<HouseAddsInfo?>?

    @DELETE("/houseaddsinfo/delete")
    fun delete(@Body houseaddsInfo: HouseAddsInfo?): Call<HouseAddsInfo?>?

    /*
    @GET("/houseaddsinfo/get-all")
    Call<List<HouseAddsInfo>> getallHouses();

    @POST("/houseaddsinfo/save")
    Call<HouseAddsInfo> save(@Body HouseAddsInfo houseaddsInfo);
    *  */
}