package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.imc20.databinding.ActivityResultBinding
import br.senai.sp.jandira.imc20.utils.getBmi
import br.senai.sp.jandira.imc20.utils.getStatusBmi

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        //Recuperar valores extras da Intent
        val weight = intent.getStringExtra("weight").toString().toInt()
        var height = intent.getDoubleExtra("height", 0.0)

        if (height == 0.0) {
            val dados = getSharedPreferences("dados", MODE_PRIVATE)
            height = dados.getFloat("height", 0.0f).toDouble()
        }

        val bmi = getBmi(weight, height)

        binding.textViewStatus.text = getStatusBmi(bmi.toString().toDouble(), this)
        binding.textViewResult.text = String.format("%.2f", bmi)
    }
}