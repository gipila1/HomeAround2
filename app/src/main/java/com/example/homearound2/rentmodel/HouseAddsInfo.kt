package com.example.homearound2.rentmodel

import android.media.Image
import android.os.Parcel
import android.os.Parcelable


class HouseAddsInfo() : Parcelable {

    var id: Int = 0
    var houseName: String? = null
    var housePlace: String? = null
    var squeredMetres: Double = 0.00
    var costOfRent: Int = 0
    var houseDetails: String? = null
    var floor: String? = null
    var yearConstructed: Int = 0
    var addressRoadNum: String? = null
    var postalCode: Int = 0
    var bedrooms: Int = 0
    var bathrooms: Int = 0
    var state: String? = null
    var energyClass: String? = null
    var airConditioning: String? = null
    var costOfSharedExpenses: Double = 0.00
    //var image: Int = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        houseName = parcel.readString()!!
        housePlace = parcel.readString()!!
        squeredMetres = parcel.readDouble()
        costOfRent = parcel.readInt()
        houseDetails = parcel.readString()!!
        floor = parcel.readString()!!
        yearConstructed = parcel.readInt()!!
        addressRoadNum = parcel.readString()!!
        postalCode = parcel.readInt()
        bedrooms = parcel.readInt()
        bathrooms = parcel.readInt()
        state = parcel.readString()!!
        energyClass = parcel.readString()!!
        airConditioning = parcel.readString()!!
        costOfSharedExpenses = parcel.readDouble()
        //image = parcel.readInt()
    }

    fun getid()=id
    fun setid(value: Int) {
        id=value
    }
    fun gethouseName()=houseName
    fun sethouseName(value: String) {
        houseName=value
    }

    fun gethousePlace()=housePlace
    fun sethousePlace(value: String) {
        housePlace=value
    }
    fun getsqueredMetres()=squeredMetres
    fun setsqueredMetres(value: Double) {
        squeredMetres=value
    }
    fun getcostOfRent()=costOfRent
    fun setcostOfRent(value: Int) {
        costOfRent=value
    }
    fun gethouseDetails()=houseDetails
    fun sethouseDetails(value: String) {
        houseDetails=value
    }
    fun getfloor()=floor
    fun setfloor(value: String) {
        floor=value
    }
    fun getyearConstructed()=yearConstructed
    fun setyearConstructed(value: Int) {
        yearConstructed=value
    }
    fun getaddressRoadNum()=addressRoadNum
    fun setaddressRoadNum(value: String) {
        addressRoadNum=value
    }
    fun getpostalCode()=postalCode
    fun setpostalCode(value: Int) {
        postalCode=value
    }
    fun getbedrooms()=bedrooms
    fun setbedrooms(value: Int) {
        bedrooms=value
    }
    fun getbathrooms()=bathrooms
    fun setbathrooms(value: Int) {
        bathrooms=value
    }
    fun getstate()=state
    fun setstate(value: String) {
        state=value
    }
    fun getenergyClass()=energyClass
    fun setenergyClass(value: String) {
        energyClass=value
    }
    fun getairConditioning()=airConditioning
    fun setairConditioning(value: String) {
        airConditioning=value
    }
    fun getcostOfSharedExpenses()=costOfSharedExpenses
    fun setcostOfSharedExpenses(value: Double) {
        costOfSharedExpenses=value
    }
    //fun getimages()=image
    //fun setimages(value: Int) {
    //    image=value
    //}

    override fun  toString(): String {
        return "houseaddsinfo{" +
                "id=" + id +
                ", Είδος σπιτιού='" + houseName + '\'' +
                ", Περιοχή='" + housePlace + '\'' +
                ", Τετραγωνικά='" + squeredMetres + '\'' +
                ", Ποσό ενοικίου='" + costOfRent + '\'' +
                ", Περιγραφή σπιτιού='" + houseDetails + '\'' +
                ", Όροφος='" + floor + '\'' +
                ", Έτος κατασκευής='" + yearConstructed + '\'' +
                ", Διεύθυνση (Οδός)='" + addressRoadNum + '\'' +
                ", TK='" + postalCode + '\'' +
                ", Αριθμός υπνοδωματίων='" + bedrooms + '\'' +
                ", Αριθμός μπάνιων='" + bathrooms + '\'' +
                ", Κατάσταση (Άριστη/Υπό ανακαίνιση)='" + state + '\'' +
                ", Ενεργειακή Κλάση='" + energyClass + '\'' +
                ", Kλιματισμός='" + airConditioning + '\'' +
                ", Κοινόχρηστα (αν υπάρχουν μ.ο. κόστους)='" + costOfSharedExpenses + '\'' +
                //", Εικόνες='" + image + '\'' +
                '}'
    }
            /*fun getId(): Int {
        return id


    fun setId(id: Int) {
        this.id = id


    fun getHouseName(): String? {
        return houseName
    }

    fun setHouseName(houseName: String) {
        this.houseName = houseName
    }

    fun getHousePlace(): String? {
        return housePlace
    }

    fun setHousePlace(housePlace: String) {
        this.housePlace = housePlace
    }

    fun getSqueredMetres(): Double {
        return squeredMetres
    }

    fun setSqueredMetres(squeredMetres: Double) {
        this.squeredMetres = squeredMetres
    }

    fun getCostOfRent(): Int {
        return costOfRent
    }

    fun setCostOfRent(costOfRent: Int) {
        this.costOfRent = costOfRent
    }

    fun getHouseDetails(): String? {
        return houseDetails
    }

    fun setHouseDetails(houseDetails: String) {
        this.houseDetails = houseDetails
    }

    fun getFloor(): String? {
        return floor
    }

    fun setFloor(floor: String) {
        this.floor = floor
    }

    fun getYearConstructed(): Int {
        return yearConstructed
    }

    fun setYearConstructed(yearConstructed: Int) {
        this.yearConstructed = yearConstructed
    }

    fun getAddressRoadNum(): String? {
        return addressRoadNum
    }

    fun setAddressRoadNum(addressRoadNum: String) {
        this.addressRoadNum = addressRoadNum
    }

    fun getPostalCode(): Int {
        return postalCode
    }

    fun setPostalCode(postalCode: Int) {
        this.postalCode = postalCode
    }
    fun getBedrooms(): Int {
        return bedrooms
    }

    fun setBedrooms(bedrooms: Int) {
        this.bedrooms = bedrooms
    }
    fun getBathrooms(): Int {
        return bathrooms
    }

    fun setBathrooms(bathrooms: Int) {
        this.bathrooms = bathrooms
    }

    fun getState(): String? {
        return state
    }

    fun setState(state: String) {
        this.state = state
    }

    fun getEnergyClass(): String? {
        return energyClass
    }

    fun setEnergyClass(energyClass: String) {
        this.energyClass = energyClass
    }

    fun getAirConditioning(): String? {
        return airConditioning
    }

    fun setAirConditioning(airConditioning: String) {
        this.airConditioning = airConditioning
    }

    fun getCostOfSharedExpenses(): Double {
        return costOfSharedExpenses
    }

    fun setCostOfSharedExpenses(costOfSharedExpenses: Double) {
        this.costOfSharedExpenses = costOfSharedExpenses
    }*/
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
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
        parcel.writeDouble(costOfSharedExpenses)
        //parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HouseAddsInfo> {
        override fun createFromParcel(parcel: Parcel): HouseAddsInfo {
            return HouseAddsInfo(parcel)
        }

        override fun newArray(size: Int): Array<HouseAddsInfo?> {
            return arrayOfNulls(size)
        }
    }
}
