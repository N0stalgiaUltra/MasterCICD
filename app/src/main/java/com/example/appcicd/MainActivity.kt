package com.example.appcicd

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appcicd.databinding.ActivityMainBinding
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {

    private var altura = 0.0f
    private var peso = 0.0f



    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCenter.start(
            application,
            "bcb96ce3-ef86-42fc-bb8b-94ca9980d128",
            Analytics::class.java,
            Crashes::class.java)

        binding.btnApplyName.setOnClickListener {
//            binding.tvNome.text = "Seu nome é: ${binding.etNome.text}"
//            Crashes.generateTestCrash()
            binding.tvNome.setText(calculateIMC())
        }
    }

    private fun calculateIMC() : String{
        altura = 1.75f
        peso = 70f

        val imc = peso / (altura * altura)

        val resultado = when{
            imc < 18.5f -> "Abaixo do peso"
            imc in 18.5f..24.9f -> "Peso normal"
            imc in 25.0f..29.9f -> "Sobrepeso"
            imc >= 30.0 -> "Obesidade"
            else -> "Valor de IMC invalido"
        }

        return "seu IMC é $imc, resultado: $resultado"
    }

}