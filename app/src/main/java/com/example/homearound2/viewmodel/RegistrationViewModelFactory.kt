package com.example.homearound2.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homearound2.AuthRepository.AuthRepository
import java.security.InvalidParameterException

class RegistrationViewModelFactory(private val authRepository: AuthRepository,private val application: Application) : ViewModelProvider.Factory {
    //we need  a viewmodel lineup providers and utility provided by android
    //if we have multiple arguments in an constructor, we need to construct a factory

    @Suppress("UNCHECKED_CAST")  //suppress this warning
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RegistrationViewModel::class.java)){  //check whether a model class is assignable to RegistrationViewModel
            return RegistrationViewModel(authRepository, application) as T
        }
           throw InvalidParameterException("Unable to construct RegistrationViewModel")   //if it is not assignable
        //return super.create(modelClass)
    }
}