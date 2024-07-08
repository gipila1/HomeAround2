package com.example.homearound2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homearound2.adapter.HouseAddsInfoAdapter
import com.example.homearound2.rentmodel.HouseAddsInfo
import com.example.homearound2.retrofit.HouseAddsInfojavaAPI
import com.example.homearound2.retrofit.RetrofitService
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Level
import java.util.logging.Logger



@Suppress("DEPRECATION")
class SelectionOfPlace2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var houselist1: List<HouseAddsInfo>
    public lateinit var houseAdapter: HouseAddsInfoAdapter

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_of_place2)

        lateinit var houseAddsInfoAdapter: HouseAddsInfoAdapter
        lateinit var linearLayoutManager: LinearLayoutManager
        recyclerView = findViewById(R.id.rvPlaceofRent)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadHousesAddsInfo()  //to check load data from server
        //loadHouseDetails()


        //var searchindatabase = findViewById<Button>(R.id.SelectPlace)
        var etplacesinput = findViewById<TextInputEditText>(R.id.etplacesinput)
        //var searchhousevar = findViewById<SearchView>(R.id.searchhouse)
        //val findhouseplace = etplacesinput.text.toString()
        //searchandloadadds()
        //etplacesinput.setOnClickListener {
        //    val intent = Intent(this, SelectionOfPlace2::class.java)
        //    startActivity(intent)          // for searching




            //val intent = Intent(this, SelectionOfPlace2::class.java)
           // startActivity(intent)
            // Εδώ να αναζητώ τις κατοικίες προς ενοικίαση της βάσης

        //}


        /* houselist = ArrayList()

        houselist.add(DataList1(R.drawable.vila, "Βίλα","Καισαριανή", 65.30, 600, "Ενα πολυτελές σπίτι με 8 δωμάτια, 3 μπάνια, πισίνα 250 τμoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo", "Ισόγειο", 1999, "Αγιου Νικολάου 13 ΤΚ ",19700,3 , 2, "Καινούργιο", "Α'", "Κλιματιστικά", 34.60 ))
        houselist.add(DataList1(R.drawable.petrino, "Πέτρινο", "Αμαλιάδα", 78.30, 570,  "Μια μεζονέτα με 3 υπνοδωμάτια, 2 μπάνια, 120 τμ", "Ισόγειο", 1999, "Αγιου Νικολάου 13 ΤΚ ", 19700,3 , 2, "Καινούργιο", "Α'", "Κλιματιστικά", 34.60 ))
        houselist.add(DataList1(R.drawable.nhsiwtiko, "Νησιώτικο", "Χανιά", 140.65, 1100,  "Σπιτι με 2 υπνοδωμάτια, 2 μπάνια, 80 τμ",  "Ισόγειο", 1999, "Αγιου Νικολάου 13 ΤΚ ",19700, 3 , 2, "Καινούργιο", "Α'", "Κλιματιστικά", 34.60 ))
        houselist.add(DataList1(R.drawable.modernomepisina, "Μοντέρνο με πισίνα", "Πύργος", 90.59, 800,  "Ένα σπίτι μοντέρνο 100 τετραγωνικών, με γυάλινες επιφάνειες", "Ισόγειο", 1999, "Αγιου Νικολάου 13 ΤΚ ",19700,3 , 2, "Καινούργιο", "Α'", "Κλιματιστικά", 34.60 ))
        houselist.add(DataList1(R.drawable.monokatoikia, "Μονοκατοικία",  "Καλαμάτα",88.20, 940, "Μια μονοκατοικία με 4 υπνοδωμάτια, 150 τμ", "Ισόγειο", 1999, "Αγιου Νικολάου 13 ΤΚ ",19700,3 , 2, "Καινούργιο", "Α'", "Κλιματιστικά", 34.60 ))
        houselist.add(DataList1(R.drawable.polykatoikia, "Πολυκατοικία", "Πάτρα", 95.20, 1000, "Μια πολυκατοικία με 4 διαμερίσματα, 60 τμ το καθένα", "Ισόγειο", 1999, "Αγιου Νικολάου 13 ΤΚ ",19700,3 , 2, "Καινούργιο", "Α'", "Κλιματιστικά", 34.60 ))
        houselist.add(DataList1(R.drawable.minimal, "Μινιμάλ", "Πάτμος", 102.40, 1230, "Μια μινιμάλ κατοικία με 3 υπνοδωμάτια, 80 τμ", "Ισόγειο", 1999, "Αγιου Νικολάου 13 ΤΚ ",19700,3 , 2, "Καινούργιο", "Α'", "Κλιματιστικά", 34.60 ))
        houselist.add(DataList1(R.drawable.ergatikikatoikia, "Εργατική κατοικία", "Θεσσαλονίκη", 63.40, 850,"Μια εργατική κατοικία με 2 υπνοδωμάτια, 65 τμ", "Ισόγειο", 1999, "Αγιου Νικολάου 13 ΤΚ ",19700,3 , 2, "Καινούργιο", "Α'", "Κλιματιστικά", 34.60 ))
        houselist.add(DataList1(R.drawable.gyalini, "Γυάλινη κατοικία", "Ορεστιάσα", 77.50, 750,"Μια κατοικία με 2 υπνοδωμάτια, 70 τμ με διαμπερές", "Ισόγειο", 1999, "Αγιου Νικολάου 13 ΤΚ ",19700,3 , 2, "Καινούργιο", "Α'", "Κλιματιστικά", 34.60 ))
        houselist.add(DataList1(R.drawable.diamerisma, "Διαμέρισμα","Κερκυρα", 80.00, 800, "Ένα διαμέρισμα με 2 υπνοδωμάτια, 600 τμ", "Ισόγειο", 1999, "Αγιου Νικολάου 13 ΤΚ ",19700,3 , 2, "Καινούργιο", "Α'", "Κλιματιστικά", 34.60 ))
        */
        /*houseAdapter = HouseAddsInfoAdapter (houselist1)
        recyclerView.adapter = houseAdapter*/

        //houseAdapter=HouseAddsInfoAdapter (houselist1)


        /*houseAdapter.onItemClick = { itemclicked ->//for switching to another activity by clicking
           val intent = Intent (this, HouseDetails:: class.java)
               intent.putExtra("house",itemclicked)  // είναι απαραίτητο;;
               startActivity(intent)
        }*/



        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy) //for scrolling
            }
        })


        val onBackPressedCallback = object : OnBackPressedCallback(true) {   //back selection
            override fun handleOnBackPressed() {
                Toast.makeText(
                    this@SelectionOfPlace2,
                    "Πίσω στην κεντρική σελίδα",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

        }
        onBackPressedDispatcher.addCallback(onBackPressedCallback)
    }

    fun loadHousesAddsInfo() {
        val retrofit = RetrofitService()
        Log.d("SelectionOfPlace2", "Retrofit works successfully")
        val houseaddsinfoApi = retrofit.retrofit?.create(HouseAddsInfojavaAPI::class.java)
        houseaddsinfoApi?.getallHouses()
            ?.enqueue(object : Callback<List<HouseAddsInfo>> {

                override fun onResponse(
                    call: Call<List<HouseAddsInfo>>,
                    response: Response<List<HouseAddsInfo>>
                ) {
                    Toast.makeText(this@SelectionOfPlace2, "Ανακτήθηκε!", Toast.LENGTH_SHORT).show()

                    response.body()?.let { populateListView(it) }
                }

                override fun onFailure(call: Call<List<HouseAddsInfo>>, t: Throwable) {
                    Toast.makeText(
                        this@SelectionOfPlace2,
                        "Αποτυχία ανάκτησης!!",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    Logger.getLogger(LeavingSoon::class.java.name)
                        .log(Level.SEVERE, "ERROR", t)// (The rest of the line is missing)
                }
            })

    }

    /*fun searchandloadadds() {
        //lateinit var houseAddsInfoAdapter: HouseAddsInfoAdapter
        var etplacesinput = findViewById<TextInputEditText>(R.id.etplacesinput)
        var searchhousevar = findViewById<SearchView>(R.id.searchhouse)

        val placeinput = etplacesinput.text.toString()
        val retrofit = RetrofitService()
        val houseaddsinfoApi = retrofit.retrofit?.create(HouseAddsInfojavaAPI::class.java)
        /* var Q : String = "select* from house_adds_info where house_place='$placeinput'"
         val st : Statement? = null
         val rs : ResultSet = st!!.executeQuery(Q)
         println(rs)*/
        /* val requestCall: Call<MutableList<HouseAddsInfo>> = searchhouseaddsApi!!.getallfromfilter(searchText = String())
        requestCall*/
        val filterValue: String = etplacesinput.toString()

        houseaddsinfoApi?.getallfromfilter(filterValue)
            ?.enqueue(object : Callback<List<HouseAddsInfo>> {

                override fun onResponse(call: Call<List<HouseAddsInfo>>, response: Response<List<HouseAddsInfo>?>) {
                    Toast.makeText(this@SelectionOfPlace2, "Επιτυχής Εμφάνιση!", Toast.LENGTH_SHORT).show()
                    val data = response.body()
                    //val listsearchedHouses : List<HouseAddsInfo> = response.body()!!
                    //recyclerView.adapter = HouseAddsInfoAdapter(listsearchedHouses)
                    //val houselist1 : List<HouseAddsInfo> = response.body()!!
                    //recyclerView.adapter = HouseAddsInfoAdapter(houselist1)
                   // println(rs)

                // val  responsebody = response.body()!!.let { populateListView(it) }

                }

                override fun onFailure(call: Call<List<HouseAddsInfo>>, t: Throwable) {
                    Toast.makeText(this@SelectionOfPlace2, "Αποτυχία ανάκτησης!!", Toast.LENGTH_SHORT)
                        .show()
                    Logger.getLogger(LeavingSoon::class.java.name)
                        .log(Level.SEVERE, "ERROR", t)// (The rest of the line is missing)
                }
            })

    }*/
    //private fun populateListViewsearch(body: List<HouseAddsInfo> ) {  //to check if body is right
    //    val houseaddsadapter : HouseAddsInfoAdapter= HouseAddsInfoAdapter(houseList1 = body)
    //    recyclerView.adapter = houseaddsadapter

    //}
    private fun populateListView(body: List<HouseAddsInfo>) {  //to check if body is right
        val houseaddsadapter: HouseAddsInfoAdapter = HouseAddsInfoAdapter(houseList1 = body)
        recyclerView.adapter = houseaddsadapter

    }

    /*fun loadHouseDetails() {

        val houseaddetails = HouseAddsInfo()
        val retrofit = RetrofitService()
        val houseaddsinfoApi = retrofit.retrofit?.create(HouseAddsInfojavaAPI::class.java)
        houseaddsinfoApi?.gethouseDetails()
            ?.enqueue(object : Callback<HouseAddsInfo> {

                override fun onResponse(
                    call: Call<HouseAddsInfo>, response: Response<HouseAddsInfo>
                ) {
                    Toast.makeText(this@SelectionOfPlace2, "Ανακτήθηκε!", Toast.LENGTH_SHORT).show()
                    //response.body()?.let { houseaddetails }
                    //val intent = Intent(this@SelectionOfPlace2, HouseDetails::class.java)

                    //  var onItemClick : ((HouseAddsInfo) -> Unit)? = null
                    //houseAdapter = HouseAddsInfoAdapter (houselist1)
                   // recyclerView.adapter = houseAdapter
                    //houseAdapter.setOnClickListener { View.OnClickListener { houseAdapter.onItemClick?.invoke(houseaddetails) } }
                   // houseAdapter.onItemClick?.invoke(houseaddetails)
                    //houseAdapter.onItemClick = {
                    //    val intent = Intent(this@SelectionOfPlace2, HouseDetails::class.java)
                    //houseAdapter.onItemClick?.let { onItemClick1(houseaddetails)  }
                    //response.body()?.let { onItemClick1(houseaddetails) }


                    //intent.putExtra(NEXT_SCREEN, house: HoudeAddsInfo)


                    //intent.putExtra("houselist1",houseaddetails)
                   // startActivity(intent)
                   // }
                   // object{
                    //    val NEXT_SCREEN="house_details"
                    //}
                    //response.body()?.let { populateListView(it) }
                }


                override fun onFailure(call: Call<HouseAddsInfo>, t: Throwable) {
                    Toast.makeText(
                        this@SelectionOfPlace2,
                        "Αποτυχία ανάκτησης!!",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    Logger.getLogger(LeavingSoon::class.java.name)
                        .log(Level.SEVERE, "ERROR", t)// (The rest of the line is missing)
                }
            })


    }*/

     public fun onItemClick1(position: Int): Unit {

            Toast.makeText(this@SelectionOfPlace2, "Ανακτήθηκε!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SelectionOfPlace2, HouseDetails::class.java)
            intent.putExtra("houseName", houselist1[position].houseName)
            intent.putExtra("housePlace", houselist1[position].housePlace)
            intent.putExtra("houseDetails", houselist1[position].houseDetails)
            intent.putExtra("squeredMetres", houselist1[position].squeredMetres)
            intent.putExtra("costOfRent", houselist1[position].costOfRent)
            intent.putExtra("floor", houselist1[position].floor)
            intent.putExtra("yearConstructed", houselist1[position].yearConstructed)
            intent.putExtra("addressRoadNum", houselist1[position].addressRoadNum)
            intent.putExtra("postalCode", houselist1[position].postalCode)
            intent.putExtra("bedrooms", houselist1[position].bedrooms)
            intent.putExtra("bathrooms", houselist1[position].bathrooms)
            intent.putExtra("state", houselist1[position].state)
            intent.putExtra("energyClass", houselist1[position].energyClass)
            intent.putExtra("airConditioning", houselist1[position].airConditioning)
            intent.putExtra("costOfSharedExpenses", houselist1[position].costOfSharedExpenses)
            // είναι απαραίτητο;;
            startActivity(intent)




    }

}



/*private fun Intent.putExtra(s: String, it: List<HouseAddsInfo>) {  //to check !!!

}*/
