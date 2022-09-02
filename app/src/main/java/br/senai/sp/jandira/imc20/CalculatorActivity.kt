package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CalculatorActivity : AppCompatActivity() {
    lateinit var buttonCalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        supportActionBar!!.hide()

        buttonCalculate = findViewById(R.id.button_calculate)
        buttonCalculate.setOnClickListener {
            val openResultActivity = Intent(this, ResultActivity::class.java)
            startActivity(openResultActivity)
        }
    }
}