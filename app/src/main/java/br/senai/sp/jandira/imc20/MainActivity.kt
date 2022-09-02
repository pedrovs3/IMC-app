package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.textSignup.setOnClickListener {
            val openSignupActivity = Intent(this, SignupActivity::class.java)
            startActivity(openSignupActivity)
        }

        binding.buttonLogin.setOnClickListener {
            login()

//            val openCalculatorActivity = Intent(this, CalculatorActivity::class.java)
//            startActivity(openCalculatorActivity)
        }
    }

    private fun login() {
        if(validateLogin()) {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            // Abrir o SharedPreferences
            val dados = getSharedPreferences("dados", MODE_PRIVATE)
            val emailSp = dados.getString("email", "Email nao encontrado")
            val passwordSp = dados.getString("password", "")

            //Verificar se os dados de autenticaçao estao corretos
            if (email == emailSp && password == passwordSp){
                openCalculatorActivity()
            } else {
                Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateLogin(): Boolean {
        if(binding.editTextEmail.text.isEmpty()){
            binding.editTextEmail.error = "E-mail is required!"
            return false
        }

        if (binding.editTextPassword.text.isEmpty()){
            binding.editTextPassword.error = "Password is required!"
            return false
        }

        return true
    }

    private fun openCalculatorActivity() {
        val openCalculatorActivity = Intent(this, CalculatorActivity::class.java)
        startActivity(openCalculatorActivity)
    }
}