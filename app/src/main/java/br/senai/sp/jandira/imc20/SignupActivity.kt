package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Definir conteúdo de visualizaçao
        setContentView(R.layout.activity_signup)

        supportActionBar!!.hide()
    }
}