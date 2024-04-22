package com.example.homearound2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.homearound2.adapter.HouseAddsInfoAdapter
import com.example.homearound2.databinding.ActivityMainBinding
import com.example.homearound2.databinding.ActivityRegistrationBinding
import com.example.homearound2.rentmodel.HouseAddsInfo


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var houselist1: List<HouseAddsInfo>
    private lateinit var houseAdapter: HouseAddsInfoAdapter

    private lateinit var mBinding: ActivityRegistrationBinding
    private lateinit var binding: ActivityMainBinding  //invoke the class of binding activity_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var buttonWantToRent: Button = binding.WantToRent
        var buttonWantToBuy: Button = binding.WantToBuy
        var buttonLeavingSoon = binding.LeavingSoon
        var buttonSelling: Button = binding.Selling
        var buttonRegistration: Button = binding.RegistrationButton
        var textWelcomeText: TextView = binding.WelcomeText
        var image: ImageView = binding.imageView2



        var wantToRent = findViewById<Button>(R.id.WantToRent)
        wantToRent.setOnClickListener {
            val intent = Intent(this, SelectionOfPlace2::class.java)
            startActivity(intent)

        }

        var leavingSoon = findViewById<Button>(R.id.LeavingSoon)
        leavingSoon.setOnClickListener {
            val intent = Intent(this, LeavingSoon::class.java)
            startActivity(intent)

        }

        var registration = findViewById<Button>(R.id.RegistrationButton)
        registration.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)

        }
    }
}