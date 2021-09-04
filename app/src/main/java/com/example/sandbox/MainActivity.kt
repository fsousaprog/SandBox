package com.example.sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
        Log.w("lifecycle", "Application CREATED!")
    }

    override fun onStart() {
        super.onStart()
        Log.w("lifecycle", "Application STARTED!")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle", "Application RESUMED!")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecycle", "Application PAUSED!")
    }

    override fun onStop() {
        super.onStop()
        Log.w("lifecycle", "Application STOPPED!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("lifecycle", "Application DESTROYED!")
    }

    private fun setListeners() {
        btnCalculate.setOnClickListener {
            calculateIMC(weight.text.toString(), height.text.toString())
        }
    }

    private fun calculateIMC(weight: String, height: String) {
        val weight = weight.toFloatOrNull()
        val height = height.toFloatOrNull()
        if (weight != null && height != null) {
            val imc = weight / (height * height)
            textView.text = "Seu IMC é %.2f".format(imc)
        }
    }
}