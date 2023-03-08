package com.dayvatas.storingdata

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dayvatas.storingdata.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Shared Preferences Initialize
        sharedPreferences = this.getSharedPreferences("com.dayvatas.storingdata", MODE_PRIVATE)
        var ageFromPreferences: Int?


        ageFromPreferences = sharedPreferences.getInt("age", -1)
        if (ageFromPreferences == -1){
            binding.textView.text = "Your Age: "
        }else{
            binding.textView.text = "Your Age: "+ ageFromPreferences
        }
    }

    fun saveClick(view : View){
        val myAge = binding.editAge.text.toString().toIntOrNull()
        if(myAge != null){
            binding.textView.text = "Your Age: " + myAge
            sharedPreferences.edit().putInt("age", myAge).apply()

        }
    }

    fun deleteClick(view: View){
        val ageFromPreferences = sharedPreferences.getInt("age", -1)
        if (ageFromPreferences != -1){
            sharedPreferences.edit().remove("age").apply()
            binding.textView.text = "Your Age: "
        }

    }
}