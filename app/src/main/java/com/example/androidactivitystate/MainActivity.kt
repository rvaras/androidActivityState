package com.example.androidactivitystate

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var name: String? = null

    companion object {
        const val MY_NAME = "MY_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button is clicker
        showYourName_button.setOnClickListener {
            name = typeName_editText.text.toString()
            displayName()
        }
    }

    private fun displayName() {
        Log.i("name", "Entered name is $name")
        typedName_textView.text = name
    }
}