package br.senai.sp.jandira.imc20.utils

import android.content.Context
import br.senai.sp.jandira.imc20.R
import kotlin.math.pow

fun getBmi(weight: Int, height: Double): Double? {
    return weight / height.pow(2)
}

fun getStatusBmi(bmi: Double, context:Context): String {

    if (bmi <= 18.5) {
        return context.getString(R.string.under_weight)
    } else if (bmi >= 18.6 && bmi < 25) {
        return context.getString(R.string.ideal_weight)
    }else if (bmi in 25.0..29.9) {
        return context.getString(R.string.light_overheight)
    }else if (bmi in 30.0..34.9) {
        return context.getString(R.string.obesity_one)
    }else if (bmi in 35.0..39.9) {
        return context.getString(R.string.obesity_two)
    }else{
        return context.getString(R.string.obesity_three)
    }
}