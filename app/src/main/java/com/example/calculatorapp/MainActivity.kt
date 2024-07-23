package com.example.calculatorapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirstNumber = findViewById<EditText>(R.id.etFirstNumber)
        val etSecondNumber = findViewById<EditText>(R.id.etSecondNumber)
        val spinnerOperations = findViewById<Spinner>(R.id.spinnerOperations)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val num1 = etFirstNumber.text.toString().toDoubleOrNull()
            val num2 = etSecondNumber.text.toString().toDoubleOrNull()
            val operation = spinnerOperations.selectedItem.toString()

            val result = when {
                num1 == null || num2 == null -> "Please enter valid numbers"
                else -> when (operation) {
                    "Addition" -> num1 + num2
                    "Subtraction" -> num1 - num2
                    "Multiplication" -> num1 * num2
                    "Division" -> if (num2 != 0.0) num1 / num2 else "Cannot divide by zero"
                    else -> "Invalid operation"
                }
            }

            tvResult.text = result.toString()
        }
    }
}
