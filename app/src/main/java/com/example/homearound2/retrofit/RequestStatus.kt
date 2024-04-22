package com.example.homearound2.retrofit

sealed class RequestStatus<out T>{  //paste the sealed class
    object Waiting: RequestStatus<Nothing>()  //to explain
    data class Success <out T>(val data: T): RequestStatus<T>()  //to explain
    data class Error(val message: HashMap<String, String>): RequestStatus<Nothing>()  //to explain


}
