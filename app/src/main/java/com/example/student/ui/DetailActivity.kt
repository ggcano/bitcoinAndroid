package com.example.student.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.student.R
import com.example.student.Student
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setIntentReceived()
    }

    private fun setIntentReceived() {
        val student = intent.getParcelableExtra<Student>("student_key")
        student?.let {
            textView_name.text = student.name
            textView_age.text = "${student.age}"

        }
    }

}
