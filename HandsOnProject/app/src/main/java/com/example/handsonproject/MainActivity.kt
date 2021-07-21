package com.example.handsonproject


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    val btn : Button = findViewById(R.id.button23) as Button
    val input : EditText = findViewById(R.id.editText1) as EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            input.setText("a")
        }
    }
}