package com.example.imcc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var Altura : EditText
    lateinit var Peso : EditText
    lateinit var btnSumar : Button
    lateinit var txtResultado : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Altura = findViewById(R.id.Altura)
        Peso = findViewById(R.id.Peso)
        btnSumar = findViewById(R.id.btnSumar)
        txtResultado = findViewById(R.id.txtResultado)

        btnSumar.setOnClickListener {
            // Obtener los valores de altura y peso desde los EditTexts y convertirlos a Double
            val altura = Altura.text.toString().toDoubleOrNull() ?: 0.0
            val peso = Peso.text.toString().toDoubleOrNull() ?: 0.0

            // Validar que los valores sean válidos y mayores a cero para evitar divisiones por cero
            if (altura > 0 && peso > 0) {
                val imc = IMC(altura, peso)  // Llamar a la función IMC
                val interpretacion = interpretarIMC(imc)  // Obtener la interpretación del IMC
                txtResultado.text = "Tu IMC es: %.2f - %s".format(imc, interpretacion)  // Mostrar el resultado con dos decimales y la interpretación
            } else {
                txtResultado.text = "Por favor, ingresa valores válidos de altura y peso."
            }
        }
    }

    }
    fun interpretarIMC(imc: Double): String {
        return when {
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.9 -> "Normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc >= 30.0 -> "Obesidad"
            else -> "Error en el cálculo"
        }
    }1.87

    fun IMC (Altura : Double, Peso : Double ) : Double {

        return Peso/(Altura*Altura)
    }

