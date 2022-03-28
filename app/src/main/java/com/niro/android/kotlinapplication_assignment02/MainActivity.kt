package com.niro.android.kotlinapplication_assignment02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SAVE_INFO", MODE_PRIVATE)

        val editTextName = findViewById<TextView>(R.id.editText_name);
        val editTextEmail = findViewById<TextView>(R.id.editText_email);
        val switch = findViewById<Switch>(R.id.switch1)
        val  saveButton = findViewById<Button>(R.id.button_save);
        val ShowInfoBtn = findViewById<Button>(R.id.ShowInfoBtn)
        val ShowInfo = findViewById<TextView>(R.id.ShowInfo)

        saveButton.setOnClickListener(){
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val savedStatus = switch.isChecked

            val editor = sharedPreferences.edit()
            editor.putString("NAME", name)
            editor.putString("EMAIL", email)
            editor.putBoolean("STATUS", savedStatus)

            editor.apply()
        }

        ShowInfoBtn.setOnClickListener(){
            val name = sharedPreferences.getString("NAME", "")
            val email = sharedPreferences.getString("EMAIL", "")
            val savedStatus = sharedPreferences.getBoolean("STATUS", false)

            ShowInfo.text = "Name : $name \nEmail : $email   \nSaved Status: $savedStatus"

        }
    }
}