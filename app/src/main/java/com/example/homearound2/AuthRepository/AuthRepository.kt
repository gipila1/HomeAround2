package com.example.homearound2.AuthRepository

import com.example.homearound2.rentmodel.ValidateEmailAddress
import com.example.homearound2.retrofit.HouseAddsInfoAPI
import com.example.homearound2.retrofit.RequestStatus
import com.example.homearound2.retrofit.SimplifiedMessage
import kotlinx.coroutines.flow.flow

class AuthRepository(val consumer: HouseAddsInfoAPI) {
    fun validateEmailAddress(body: ValidateEmailAddress) = flow {
    emit(RequestStatus.Waiting)
        val response = consumer.validateemailEmailAddress(body)
        if (response.isSuccessful){
            emit((RequestStatus.Success(response.body()!!)))
        }else {
            emit(RequestStatus.Error(SimplifiedMessage.get(response.errorBody()!!.byteStream().reader().readText())))  //this with project an error of a wrong email/if the response isn't successful
        }
    }
}