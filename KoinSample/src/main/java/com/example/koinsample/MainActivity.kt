package com.example.koinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.koinSample.R
import com.example.koinsample.manager.UmbrellaManager
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent

class MainActivity : AppCompatActivity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUmbrellaPrice()
    }


    /**
     * koin - module set inject IWeather to umbrellaForKoin Constructor
     */
    private fun getUmbrellaPrice() {
        val umbrellaForKoin: UmbrellaManager by inject()
        val totalPrice = umbrellaForKoin.totalPrice(1, 100)
        showDialog(totalPrice.toString())
    }

    private fun showDialog(message: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setTitle("Umbrella Price ")
        alertDialog.setMessage(message)
        alertDialog.show()
    }
}