package com.example.disample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.automatedtestpractice.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUmbrellaPrice()

    }


    /**
     * interface inject IWeather to Umbrella().totalPrice() function
     */
    private fun getUmbrellaPrice() {
        val totalPrice = UmbrellaManager().totalPrice(1, 100, object : IWeather {
            override fun isSunny(): Boolean {
                return true
            }
        })
        showDialog(totalPrice.toString())
    }

    private fun showDialog(message: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setTitle("Umbrella Price ")
        alertDialog.setMessage(message)
        alertDialog.show()
    }

}