package com.example.homearound2.rentmodel

import android.os.Build
import android.os.Parcel
import androidx.annotation.RequiresApi

class UniqueEmailAddressValidationResponce {
    var isUnique: Boolean? = null
    var userRegistrationInfo: String? = null


    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this() {
        isUnique = parcel.readBoolean()!!
        userRegistrationInfo = parcel.readString()
    }

    constructor()   //to check the secondary constructor

    fun getisUnique() = isUnique
    fun setisUnique(value: Boolean) {
        isUnique = value
    }
    fun getuserRegistrationInfo() = userRegistrationInfo
    fun setuserRegistrationInfo(value: String) {
        userRegistrationInfo = value
    }

    override fun toString(): String {
        return "userregistrationinfo{" +
                ", isUnique='" + isUnique + '\'' +
                ", userRegistrationInfo='" + userRegistrationInfo + '\'' +
                '}'
    }

     fun writeToParcel(parcel: Parcel, flags: String) {  //maybe override

        //parcel.writeBoolean(isUnique)
        parcel.writeString(userRegistrationInfo)

    }
}