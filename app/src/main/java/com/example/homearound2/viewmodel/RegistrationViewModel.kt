package com.example.homearound2.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homearound2.AuthRepository.AuthRepository
import com.example.homearound2.rentmodel.UserRegistrationInfo
import com.example.homearound2.rentmodel.ValidateEmailAddress
import com.example.homearound2.retrofit.RequestStatus
import kotlinx.coroutines.launch

class RegistrationViewModel(val authRepository: AuthRepository, val application: Application): ViewModel() {    //we add the in this line because we require repository an application in order to get access to the context
//we need  a viewmodel lineup providers and utility provided by android
    //if we have multiple arguments in an constructor, we need to construct a factory

    //then we create a private var
    private var isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply{ value = false}
    //creates a mutable live data with no value yet assigned
    private var errorMessage: MutableLiveData<HashMap<String, String>> = MutableLiveData() //these are messages that we will examine through an api call
    private var isUniqueEmail: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply{ value = false}
    private var UserRegistrationInfo: MutableLiveData<UserRegistrationInfo> = MutableLiveData()

    //define getters and function to this mutablelivedata that will return mutablelivedata only
    fun getIsLoading(): LiveData<Boolean> = isLoading
    fun getErrorMessage(): LiveData<HashMap<String, String>> = errorMessage
    fun getIsUniqueEmail(): LiveData<Boolean> = isUniqueEmail
    fun getUser(): LiveData<UserRegistrationInfo> = UserRegistrationInfo

    fun validateEmailAddress(body: ValidateEmailAddress){    //we create a viewmodel and a scope
        viewModelScope.launch {
            authRepository.validateEmailAddress(body).collect{  //here we create a coroutine
                when(it){     //here we collect and have access to a requitition status
                    is RequestStatus.Waiting -> {   //when we are waiting for an api in response
                        isLoading.value = true     //we set isloading to the value to true so under loading will be shown a spinner in activity
                    }
                    is RequestStatus.Success -> {  //here is when the request is a success
                        isLoading.value = false  //we set false here because when we reach through an api, the connection  will be completed
                        isUniqueEmail.value = it.data.isUnique
                    }
                    is RequestStatus.Error -> {   //here is when the request has an error
                        isLoading.value = false   //we set false here because when we reach through an api, the connection  will be completed
                        errorMessage.value = it.message

                    }
                }
            }
        }

    }
}