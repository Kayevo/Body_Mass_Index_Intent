package com.kayevo.bodymassindexintent.presentation.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kayevo.bodymassindexintent.R
import com.kayevo.bodymassindexintent.databinding.ActivityBmiactivityBinding

class BMIActivity : AppCompatActivity() {
    private lateinit var viewBMI: ActivityBmiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBMI = ActivityBmiactivityBinding.inflate(layoutInflater)
        setContentView(viewBMI.root)

        val weight = intent.getDoubleExtra("EXTRA_WEIGHT", 0.0)
        val height = intent.getDoubleExtra("EXTRA_HEIGHT", 0.0)

        var bmi = (weight / (height * height))

        viewBMI.bmiResult.text = bmi.shorten(2).toString()
    }

    fun Double.shorten(decimals: Int): Double {
        return String.format("%.$decimals" + "f", this).replace(',', '.').toDouble()
    }
}