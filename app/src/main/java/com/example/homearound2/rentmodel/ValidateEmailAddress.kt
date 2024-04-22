package com.example.homearound2.rentmodel

import android.os.Parcel
import android.os.Parcelable

class ValidateEmailAddress : Parcelable {

    var email: String? = null


    constructor(parcel: Parcel) : this() {
        email = parcel.readString()!!

    }

    constructor()   //to check the secondary constructor

    fun getemail() = email
    fun setemail(value: String) {
        email = value
    }

    override fun toString(): String {
        return "userregistrationinfo{" +
                ", Email='" + email + '\'' +
                '}'
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(email)


    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ValidateEmailAddress> {
        override fun createFromParcel(parcel: Parcel): ValidateEmailAddress {
            return ValidateEmailAddress(parcel)
        }

        override fun newArray(size: Int): Array<ValidateEmailAddress?> {
            return arrayOfNulls(size)
        }
    }
}