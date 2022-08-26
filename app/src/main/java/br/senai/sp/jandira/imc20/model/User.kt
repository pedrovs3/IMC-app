package br.senai.sp.jandira.imc20.model

import kotlin.math.pow

class User {

    var id = 0
    var name = ""
    var email = ""
    var password = ""
    var weight = 0
    var height = 0.0

    fun getBmi(): Double {
        return weight / height.pow(2)
    }

    fun getStatusBmi(): String {
        val bmi = getBmi()

        if (bmi <= 18.5) {
            return "Abaixo do peso."
        } else if (bmi >= 18.6 && bmi < 25) {
            return "Peso ideal."
        }else if (bmi in 25.0..29.9) {
            return "Levemente acima do peso."
        }else if (bmi in 30.0..34.9) {
            return "Obesidade grau I."
        }else if (bmi in 35.0..39.9) {
            return "Obesidade grau II (severa)."
        }else{
            return "Obesidade III (mórbida)."
        }
    }
}