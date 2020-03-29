package com.example.student.ui


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.student.R
import com.example.student.Student
import kotlinx.android.synthetic.main.activity_main.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
val arreglo = intArrayOf(1,2,3,4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        obeserveData()
        refresh()
    }

    private fun refresh() {
        floatingActionButton.setOnClickListener {
            obeserveData()
        }
    }

    private fun goIntentObject() {
        val intent = Intent(this, DetailActivity::class.java)

        val student = Student("Jose", "Garcia", 21, false)
        intent.putExtra("student_key", student)
        startActivity(intent)
    }

    private fun obeserveData() {
        viewModel.coinData().observe(this, Observer {
            val floatRateEur = it.bpi.eur.rateFloatDTO
            val floatRateUsd = it.bpi.usd.rateFloatDTO
            val floatRateGpb = it.bpi.gpb.rateFloatDTO
            val timeGMT = it.time.updatedISO
            // val date = LocalDate.parse(timeGMT, DateTimeFormatter.ISO_DATE)

            txt.text = "$floatRateUsd $"
            txt2.text = "$floatRateEur €"
            txt3.text = "$floatRateGpb L"


            val dtStart = "2019-12-17T10:57:00+00:00"
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val calendar = Calendar.getInstance()
            try {
                val date: Date = format.parse(timeGMT)
                calendar.timeInMillis = date.time
                calendar.add(Calendar.HOUR, 1)

                //System.out.println(date)

                txt_time.text = date.toString()
            } catch (e: ParseException) {
                e.printStackTrace()
            }


        })
    }

}




