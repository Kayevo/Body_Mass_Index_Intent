package com.kayevo.bodymassindexintent.presentation.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kayevo.bodymassindexintent.R
import com.kayevo.bodymassindexintent.databinding.ActivityFormBinding
import com.kayevo.bodymassindexintent.presentation.result.BMIActivity

class FormActivity : AppCompatActivity() {
    private lateinit var viewForm: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewForm = ActivityFormBinding.inflate(layoutInflater)
        setContentView(viewForm.root)

        viewForm.generateBMI.setOnClickListener{
            Intent(this, BMIActivity::class.java).also {
                it.putExtra("EXTRA_WEIGHT", viewForm.weight.text.toString().toDouble())
                it.putExtra("EXTRA_HEIGHT", viewForm.height.text.toString().toDouble())
                startActivity(it)
            }
        }
    }
}