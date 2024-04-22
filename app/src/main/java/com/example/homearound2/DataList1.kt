package com.example.homearound2

import android.os.Parcel
import android.os.Parcelable

data class DataList1(val image: Int,
                     val houseName: String,
                     val housePlace: String,
                     val squeredMetres: Double,
                     val costOfRent: Int,
                     val houseDetails: String,
                     val floor: String,
                     val yearConstructed: Int,
                     val addressRoadNum: String,
                     val postalCode: Int,
                     val bedrooms: Int,
                     val bathrooms: Int,
                     val state: String,
                     val energyClass: String,
                     val airConditioning: String,
                     val costOfSharedExpenses: Double
                                              )
                      : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt()!!,
        parcel.readInt()!!,
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble()!!




    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(houseName)
        parcel.writeString(housePlace)
        parcel.writeDouble(squeredMetres)
        parcel.writeInt(costOfRent)
        parcel.writeString(houseDetails)
        parcel.writeString(floor)
        parcel.writeInt(yearConstructed)
        parcel.writeString(addressRoadNum)
        parcel.writeInt(postalCode)
        parcel.writeInt(bedrooms)
        parcel.writeInt(bathrooms)
        parcel.writeString(state)
        parcel.writeString(energyClass)
        parcel.writeString(airConditioning)
        parcel.writeDouble(squeredMetres)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataList1> {
        override fun createFromParcel(parcel: Parcel): DataList1 {
            return DataList1(parcel)
        }

        override fun newArray(size: Int): Array<DataList1?> {
            return arrayOfNulls(size)
        }
    }
}
