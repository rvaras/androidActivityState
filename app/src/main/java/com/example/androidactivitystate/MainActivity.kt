package com.example.androidactivitystate

import android.view.inputmethod.InputMethodManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.view.View;
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

        // Button is clicked
        showYourName_button.setOnClickListener {
            name = typeYourName_TextInput.text.toString()
            val myCopy: String? = name

            // Get the current view
            val view: View? = this.currentFocus

            if (myCopy?.isEmpty() == true) {
                Toast.makeText(applicationContext, "Name value is empty. Please type a name.", Toast.LENGTH_SHORT).show()
                typedName_textView.text=""
            } else {
                if (view != null) {
                    // Create a variable for input manager and init it
                    val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

                    // Hide software keyboard
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)
                }
                displayName()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("State:","Entered onSaveInstanceState")
        outState.putString(MY_NAME, name)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("State:","Entered onRestoreInstanceState")
        name = savedInstanceState.getString(MY_NAME)
        displayName()
    }

    // Will display the typed name in the textview component
    private fun displayName() {
        println("Entered name is $name")
        typedName_textView.text = name
    }
}