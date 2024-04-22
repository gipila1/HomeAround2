package com.example.homearound2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.homearound2.databinding.ActivityHouseDetailsBinding
import com.example.homearound2.databinding.ActivityMainBinding
import com.example.homearound2.databinding.ActivityRegistrationBinding
import com.example.homearound2.rentmodel.HouseAddsInfo
import com.example.homearound2.retrofit.HouseAddsInfojavaAPI
import com.example.homearound2.retrofit.RetrofitService
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Level
import java.util.logging.Logger

class HouseDetails : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap  //  create a variable for Google maps
    private lateinit var detailsBinding: ActivityHouseDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsBinding = ActivityHouseDetailsBinding.inflate(LayoutInflater.from(this))

        setContentView(R.layout.activity_house_details)
        val houseList2: List<HouseAddsInfo>? =null
        var position1 : Int? = null
        val houseserverlist : HouseAddsInfo? = position1?.let { houseList2?.get(it) }
        loadhousedetailsfromserver(houseserverlist)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment     // Google Maps
        mapFragment.getMapAsync(this)




        val onBackPressedCallback = object : OnBackPressedCallback( true){
            override fun handleOnBackPressed() {
                Toast.makeText(this@HouseDetails, "Back to Selection", Toast.LENGTH_SHORT).show()
                finish()
            }

        }
        onBackPressedDispatcher.addCallback(onBackPressedCallback)





    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
    fun loadhousedetailsfromserver(houseserverlist: HouseAddsInfo?) {

        val houseList1 = intent.getParcelableExtra<HouseAddsInfo>("houseList1")
        if (houseList1 != null){
            val imageView : ImageView = findViewById(R.id.HouseDetailsall)
            val textViewplace : TextView = findViewById(R.id.HousePlacetextall)
            val textView : TextView = findViewById(R.id.HouseDetailstexttitle)
            val textViewdet : TextView = findViewById(R.id.HouseDetailstextall)
            val textsquaremetres : TextView = findViewById(R.id.SquareMetres)
            val textcostofrent : TextView = findViewById(R.id.CostOfRent)
            val floornn : TextView = findViewById(R.id.Floor)
            val yearconstructed : TextView = findViewById(R.id.YearConstructed)
            val addressroadnum : TextView = findViewById(R.id.AddressRoad)
            val postalcode : TextView = findViewById(R.id.PostalCode)
            val bedroomss : TextView = findViewById(R.id.Bedrooms)
            val bathroomss : TextView = findViewById(R.id.Bathrooms)
            val statestate : TextView = findViewById(R.id.State)
            val energyclasss : TextView = findViewById(R.id.EnergyClass)
            val airgconditioning : TextView = findViewById(R.id.AirConditioning)
            val costofsharedexpensess : TextView = findViewById(R.id.CostOfSharedExpenses)

            val retrofit = RetrofitService()
            val houseaddsinfoApi = retrofit.retrofit?.create(HouseAddsInfojavaAPI::class.java)

            val houseaddetails = HouseAddsInfo()
            textView.text= houseaddetails.houseName
            textViewplace.text= houseaddetails.housePlace
            textViewdet.text = houseaddetails.houseDetails
            //imageView.setImageResource(house.image)
            textsquaremetres.text=houseaddetails.squeredMetres.toString()
            textcostofrent.text=houseaddetails.costOfRent.toString()
            floornn.text=houseaddetails.floor
            yearconstructed.text=houseaddetails.yearConstructed.toString()
            addressroadnum.text=houseaddetails.addressRoadNum
            postalcode.text=houseaddetails.postalCode.toString()
            bedroomss.text=houseaddetails.bedrooms.toString()
            bathroomss.text=houseaddetails.bathrooms.toString()
            statestate.text=houseaddetails.state
            energyclasss.text=houseaddetails.energyClass
            airgconditioning.text=houseaddetails.airConditioning
            costofsharedexpensess.text=houseaddetails.costOfSharedExpenses.toString()

            houseaddsinfoApi?.gethouseDetails()
                ?.enqueue(object : Callback<HouseAddsInfo> {

                    override fun onResponse(call: Call<HouseAddsInfo>, response: Response<HouseAddsInfo>) {
                        Toast.makeText(this@HouseDetails, "Ανακτήθηκε!", Toast.LENGTH_SHORT).show()

                        response.body()?.let { it }
                    }

                    override fun onFailure(call: Call<HouseAddsInfo>, t: Throwable) {
                        Toast.makeText(this@HouseDetails, "Αποτυχία ανάκτησης!!", Toast.LENGTH_SHORT)
                            .show()
                        Logger.getLogger(HouseDetails::class.java.name)
                            .log(Level.SEVERE, "ERROR", t)// (The rest of the line is missing)
                    }
                })

        }







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


        fun toString(): String {
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
                    '}'
        }





    }
}