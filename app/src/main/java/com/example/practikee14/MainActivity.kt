package com.example.practikee14

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val ageEditText = findViewById<EditText>(R.id.editTextDate)
        val nameEditText = findViewById<EditText>(R.id.editTextText)


        val intent = intent
        val email = intent.getStringExtra("EMAIL") ?: ""
        val age = intent.getStringExtra("AGE") ?: ""
        val name = intent.getStringExtra("NAME") ?: ""

        emailEditText.setText(email)
        ageEditText.setText(age)
        nameEditText.setText(name)


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val updatedEmail = emailEditText.text.toString()
            val updatedAge = ageEditText.text.toString()
            val updatedName = nameEditText.text.toString()

            if (updatedEmail.isNotEmpty() && updatedAge.isNotEmpty() && updatedName.isNotEmpty()) {
                val intent = Intent(this@MainActivity, MainActivity2::class.java).apply {
                    putExtra("EMAIL", updatedEmail)
                    putExtra("AGE", updatedAge)
                    putExtra("NAME", updatedName)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Вы должны везде ввести данные!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
