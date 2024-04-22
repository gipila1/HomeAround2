package com.example.homearound2.rentmodel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class UserRegistrationInfo() : Parcelable {
    @SerializedName("_id")

    private var id: Int = 0
    var fullName: String? = null
    var userName: String? = null
    var email: String? = null
    var phoneNumber: Int = 0
    var code: String? = null
    var confirmationCode: String? = null


    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        fullName = parcel.readString()!!
        userName = parcel.readString()!!
        email = parcel.readString()!!
        phoneNumber = parcel.readInt()
        code = parcel.readString()!!
        confirmationCode = parcel.readString()!!
    }

      //to check the secondary constructor

    fun getid()=id
    fun setid(value: Int) {
        id=value
    }
    fun getfullName()=fullName
    fun setfullName(value: String) {
        fullName=value
    }

    fun getuserName()=userName
    fun setuserName(value: String) {
        userName=value
    }
    fun getemail()=email
    fun setemail(value: String) {
        email=value
    }
    fun getphoneNumber()=phoneNumber
    fun setphoneNumber(value: Int) {
        phoneNumber=value
    }
    fun getcode()=code
    fun setcode(value: String) {
        code = value
    }
    fun getconfirmationCode()=confirmationCode
    fun setconfirmationCode(value: String) {
        confirmationCode = value
    }
    override fun  toString(): String {
        return "userregistrationinfo{" +
                "id=" + id +
                ", Ονομεταπώνυμο='" + fullName + '\'' +
                ", Όνομα Χρήστη='" + userName + '\'' +
                ", Email='" + email + '\'' +
                ", Αριθμός Τηλεφώνου='" + phoneNumber + '\'' +
                ", Κωδικός='" + code + '\'' +
                ", Επιβεβαίωση Κωδικού='" + confirmationCode + '\'' +
                '}'
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(fullName)
        parcel.writeString(userName)
        parcel.writeString(email)
        parcel.writeInt(phoneNumber)
        parcel.writeString(code)
        parcel.writeString(confirmationCode)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserRegistrationInfo> {
        override fun createFromParcel(parcel: Parcel): UserRegistrationInfo {
            return UserRegistrationInfo(parcel)
        }

        override fun newArray(size: Int): Array<UserRegistrationInfo?> {
            return arrayOfNulls(size)
        }
    }
}