package com.example.hiltsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.hiltsample.manager.UmbrellaManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint // Hilt的入口點
class MainActivity : AppCompatActivity() {

    @Inject //宣告注入的依賴物件
    lateinit var umbrellaManager: UmbrellaManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDialog(umbrellaManager.totalPrice(1, 100).toString())
    }

    private fun showDialog(message: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setTitle("Umbrella Price ")
        alertDialog.setMessage(message)
        alertDialog.show()
    }
}