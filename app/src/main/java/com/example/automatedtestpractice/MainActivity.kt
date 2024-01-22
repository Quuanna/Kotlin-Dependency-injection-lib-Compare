package com.example.automatedtestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.automatedtestpractice.data.ListItemType
import com.example.automatedtestpractice.databinding.ActivityMainBinding
import com.example.automatedtestpractice.diSamplePractice.IWeather
import com.example.automatedtestpractice.diSamplePractice.Umbrella
import com.example.automatedtestpractice.koinSamplePractice.UmbrellaForKoin
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private val recycleView get() = binding.recycleView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        adapter = MainAdapter(ListItemType.values())
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false)

        adapter.addOnClickEventListener(object : MainAdapter.OnGetItemDataListener {
            override fun onCheckedChanged(type: ListItemType, isOpen: Boolean) {
                when (type) {
                    ListItemType.DI_SAMPLE_PRACTICE -> { // DI interface IWeather
                        val result = getUmbrellaPrice(if (isOpen) "晴天" else "雨天", isOpen)
                        showDialog(result)
                    }

                    ListItemType.KOIN_SAMPLE_PRACTICE -> { // koin
                        val resultKoin = getUmbrellaPriceFromKoin(isOpen)
                        showDialog(resultKoin)
                    }

                    ListItemType.HILT_SAMPLE_PRACTICE -> { // hilt

                    }
                }
            }
        })
    }

    /**
     * interface inject IWeather to Umbrella().totalPrice() function
     */
    private fun getUmbrellaPrice(weather: String, boolean: Boolean): String {
        val totalPrice = Umbrella().totalPrice(1, 100, object : IWeather {
            override fun isSunny(): Boolean {
                return boolean
            }
        })
        return weather.plus(" ").plus(totalPrice).plus("元")
    }


    /**
     * koin - module set inject IWeather to umbrellaForKoin Constructor
     */
    private fun getUmbrellaPriceFromKoin(boolean: Boolean): String {
        val umbrellaForKoin: UmbrellaForKoin by inject()
        val weatherText = if (boolean) "晴天" else "雨天"
        umbrellaForKoin.isSunny = boolean
        val totalPrice = umbrellaForKoin.totalPrice(1, 100)
        return weatherText.plus(" ").plus(totalPrice).plus("元")
    }

    private fun showDialog(message: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setTitle("Umbrella Price ")
        alertDialog.setMessage(message)
        alertDialog.show()
    }

}