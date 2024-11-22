package com.example.practikee14

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val ageEditText = findViewById<EditText>(R.id.editTextDate2)
        val nameEditText = findViewById<EditText>(R.id.editTextText2)
        val intent = intent
        val email = intent.getStringExtra("EMAIL") ?: ""
        val age = intent.getStringExtra("AGE") ?: ""
        val name = intent.getStringExtra("NAME") ?: ""

        emailEditText.setText(email)
        ageEditText.setText(age)
        nameEditText.setText(name)

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            val updatedEmail = emailEditText.text.toString()
            val updatedAge = ageEditText.text.toString()
            val updatedName = nameEditText.text.toString()

            if (updatedEmail.isNotEmpty() && updatedAge.isNotEmpty() && updatedName.isNotEmpty()) {
                val resultIntent = Intent(this@MainActivity2, MainActivity::class.java).apply {
                    putExtra("EMAIL", if (updatedEmail != email) "$updatedEmail*" else updatedEmail)
                    putExtra("AGE", if (updatedAge != age) "$updatedAge*" else updatedAge)
                    putExtra("NAME", if (updatedName != name) "$updatedName*" else updatedName)
                }
                Toast.makeText(this, "Данные изменены!!", Toast.LENGTH_LONG).show()
                startActivity(resultIntent)
            } else {
                Toast.makeText(this, "Невозможно сохранить пустые данные!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}