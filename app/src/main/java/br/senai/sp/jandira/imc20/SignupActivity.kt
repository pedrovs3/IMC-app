package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.senai.sp.jandira.imc20.databinding.ActivitySignupBinding
import br.senai.sp.jandira.imc20.model.User

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Definir conteúdo de visualização
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.buttonUserCreate.setOnClickListener {
            if (validate()) {
                saveUser()
            }
        }
    }

    private fun validate():Boolean {
        if (binding.editTextName.text.isEmpty()) {
            binding.editTextName.error = "Digite o nome de usuário"
            return false
        }else if (binding.editTextEmail.text.isEmpty()) {
            binding.editTextEmail.error = "Digite o Email de login"
            return false
        }else if (binding.editTextPassword.text.isEmpty()) {
            binding.editTextPassword.error = "Digite uma senha de login"
            return false
        }else if (binding.editTextWeight.text.isEmpty()) {
            binding.editTextWeight.error = "Digite o seu peso"
            return false
        }else if (binding.editTextHeight.text.isEmpty()) {
            binding.editTextHeight.error = "Digite sua altura"
            return false
        }
        return true
    }

    private fun saveUser() {
        val user = User()

        user.id = 1
        user.name = binding.editTextName.text.toString()
        user.email = binding.editTextEmail.text.toString()
        user.password = binding.editTextPassword.text.toString()
        user.weight = binding.editTextWeight.text.toString().toInt()
        user.height = binding.editTextHeight.text.toString().toDouble()

        // Gravar usuário no SharedPreferences
        //Step 1 - Obter uma instancia do SharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        // Step 2 - Criar um editor para o arquivo
        val editor = dados.edit()

        //Step 3 - Inserir dados no arquivo SharedPreferences
        editor.putInt("id", user.id)
        editor.putString("name", user.name)
        editor.putString("email", user.email)
        editor.putString("password", user.password)
        editor.putInt("weight", user.weight)
        editor.putFloat("height", user.height.toFloat())

        if(editor.commit()) {
            Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Ocorreu um erro no cadastro.", Toast.LENGTH_SHORT).show()
        }
    }

}