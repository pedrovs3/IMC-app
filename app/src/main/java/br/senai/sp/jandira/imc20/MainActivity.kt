package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textSignup: TextView
    lateinit var buttonLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textSignup = findViewById(R.id.text_signup)

        textSignup.setOnClickListener {
            val openSignupActivity = Intent(this, SignupActivity::class.java)
            startActivity(openSignupActivity)
        }
        supportActionBar!!.hide()

//        buttonLogin = findViewById(R.id.buttonLogin)
//        buttonLogin.setOnClickListener {
//            val openCalculatorActivity = Intent(this, CalculatorActivity::class.java)
//            startActivity(openCalculatorActivity)
//        }
    }
}