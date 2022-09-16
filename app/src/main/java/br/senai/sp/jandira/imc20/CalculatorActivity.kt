package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import br.senai.sp.jandira.imc20.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        loadProfile()

        binding.buttonCalculate.setOnClickListener {
            if(validate()) {
                updateData()
                bmiCalculate()
            }
        }
    }

    private fun validate(): Boolean {
        if(binding.editTextWeight.text.isEmpty()) {
            binding.editTextWeight.error = "Valor requirido."
            return false
        }
        return true
    }

    private fun bmiCalculate() {
        val openResultActivity = Intent(this, ResultActivity::class.java)

        // Enviar dados de uma activity para outra
        openResultActivity.putExtra("weight", binding.editTextWeight.text.toString())
        openResultActivity.putExtra("height", binding.editTextHeight.text.toString())

        startActivity(openResultActivity)
    }

    private fun loadProfile() {
        // Abrindo o arquivo sharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewUsername.text = dados.getString("name", "")
        binding.textViewEmail.text = dados.getString("email", "")
        binding.textViewWeight.text = "${resources.getText(R.string.weight_label)}: ${dados.getInt("weight", 0)}Kg"
        binding.textViewHeight.text = "${resources.getText(R.string.height_label)}: ${dados.getFloat("height", 0.0f)}m"
    }

    private fun updateData() {
        val dados = getSharedPreferences("dados", MODE_PRIVATE)
        val editor = dados.edit()

        if (!binding.editTextHeight.text.isEmpty()) {
            editor.putFloat("height", binding.editTextHeight.text.toString().toFloat())
        }

        editor.putInt("weight", binding.editTextWeight.text.toString().toInt())

        editor.apply()
    }
}