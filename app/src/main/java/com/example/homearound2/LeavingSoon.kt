package com.example.homearound2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homearound2.databinding.ActivityMainBinding
import com.example.homearound2.retrofit.RetrofitService
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.example.homearound2.rentmodel.HouseAddsInfo
import com.example.homearound2.retrofit.HouseAddsInfoAPI
import com.example.homearound2.retrofit.HouseAddsInfojavaAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Level
import java.util.logging.Logger

class LeavingSoon : AppCompatActivity() {




    //private  val selectedImageUri: Uri?= null
    //private  val imageview1 : ImageView= findViewById<ImageView>(R.id.imageview1)
    //  private  val selectimagem : Button= findViewById<Button>(R.id.selectimage)


    private lateinit var binding: ActivityMainBinding
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_leaving_soon)

       // val selectimagem : Button= findViewById<Button>(R.id.selectimage)
        //imageview1.setOnClickListener{
          //  openImageChooser()
        //}
       // selectimagem.setOnClickListener{
          // uploadImages()
       // }
        initializeComponents()
    }

    /*private fun uploadImages() {

    }*/



    //private fun openImageChooser() {
    //    Intent(Intent.ACTION_PICK).also {
    //        it.type = "image/*"
    //        val mimeTypes = arrayOf("image/jpeg", "image/png", "image/jpg" )
    //        it.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
    //        startActivityForResult(it, REQUEST_CODE_IMAGE)
    //    }
    //}

    //override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    //    super.onActivityResult(requestCode, resultCode, data)
    //    if (requestCode== Activity.RESULT_OK){
    //        when(requestCode){
    //            REQUEST_CODE_IMAGE -> {
    //                selectedImageUri = data?.data
    //                imageview1.setImageURI(selectedImageUri)  //to check
    //            }
    //        }

    //    }
    //}
    //companion object {
    //    const val REQUEST_CODE_IMAGE = 101
    //}


    private fun initializeComponents() {

         val inputofkindofhousen :TextView= findViewById <TextInputEditText>(com.example.homearound2.R.id.InputOfKindOfHouse)
         val inputofplacen : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfPlace)
         val inputofsquaremetresn : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfSquareMetres)
         val inputofcostofrentn : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfCostOfRent)
         val inputofyearconstructedn  : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfYearConstructed)
         val inputofaddressaoadn : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfAddressRoad)
         val inputofpostalcoden : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfPostalCode)
         val inputoffloorn : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfFloor)
         val inputofbedroomsn : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfBedrooms)
         val inputofbathroomsn : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfBathrooms)  //check this line
         val inputofstaten : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfState)
         val inputofenergyclassn : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfEnergyClass)
         val inputofairconditioningn : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfAirConditioning)
         val inputofcostofsharedexpensesn : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfCostOfSharedExpenses)
         val inputofhouseshortdescriptionn : TextView= findViewById<TextInputEditText>(com.example.homearound2.R.id.InputOfHouseShortDescription)
         val savingdetailsbutton : TextView= findViewById<MaterialButton>(com.example.homearound2.R.id.SavingDetailsButton)


         val retrofit = RetrofitService()
         val houseaddsinfoApi = retrofit.retrofit?.create(HouseAddsInfojavaAPI::class.java)


         savingdetailsbutton.setOnClickListener { view ->

            val houseName = inputofkindofhousen.text.toString()
            val housePlace = inputofplacen.text.toString()
            val squeredMetres = inputofsquaremetresn.text.toString()
            val costOfRent = inputofcostofrentn.text.toString()
            val yearConstructed = inputofyearconstructedn.text.toString()
            val addressRoadNum = inputofaddressaoadn.text.toString()
            val postalCode = inputofpostalcoden.text.toString()
            val floor = inputoffloorn.text.toString()
            val bedrooms= inputofbedroomsn.text.toString()
            val bathrooms = inputofbathroomsn.text.toString()
            val state = inputofstaten.text.toString()
            val energyClass = inputofenergyclassn.text.toString()
            val airConditioning = inputofairconditioningn.text.toString()
            val costOfSharedExpenses = inputofcostofsharedexpensesn.text.toString()
            val houseDetails = inputofhouseshortdescriptionn.text.toString()
             //val image1 = image11.toString()   //to check



            val houseaddsInfo = HouseAddsInfo()
             houseaddsInfo.sethouseName(houseName)
             houseaddsInfo.sethousePlace(housePlace)
             houseaddsInfo.setsqueredMetres(squeredMetres.toDouble())
             houseaddsInfo.setcostOfRent(costOfRent.toInt())
             houseaddsInfo.setyearConstructed(yearConstructed.toInt())
             houseaddsInfo.setaddressRoadNum(addressRoadNum)
             houseaddsInfo.setpostalCode(postalCode.toInt())
             houseaddsInfo.setfloor(floor)
             houseaddsInfo.setbedrooms(bedrooms.toInt())
             houseaddsInfo.setbathrooms(bathrooms.toInt())
             houseaddsInfo.setstate(state)
             houseaddsInfo.setenergyClass(energyClass)
             houseaddsInfo.setairConditioning(airConditioning)
             houseaddsInfo.setcostOfSharedExpenses(costOfSharedExpenses.toDouble())
             houseaddsInfo.sethouseDetails(houseDetails)
             //houseaddsInfo.setimages(image1.toInt())


             //houseaddsinfoApi?.upload(image1)
            houseaddsinfoApi?.save(houseaddsInfo)
                ?.enqueue(object : Callback<HouseAddsInfo> {

                    override fun onResponse(
                        call: Call<HouseAddsInfo>, response: Response<HouseAddsInfo>
                    ) {
                        Toast.makeText(this@LeavingSoon, "Αποθηκεύτηκε!", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<HouseAddsInfo>, t: Throwable) {
                        Toast.makeText(this@LeavingSoon, "Αποτυχία αποθήκευσης!!", Toast.LENGTH_SHORT).show()
                        Logger.getLogger(LeavingSoon::class.java.name).log(Level.SEVERE, "ERROR", t)// (The rest of the line is missing)
                    }


                })
        }
    }

}





