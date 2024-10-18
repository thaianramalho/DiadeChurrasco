package com.thaianramalho.diadechurrasco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btn_calcular)
        val numeroHomens: EditText = findViewById(R.id.txt_numHomens)
        val numeroMulheres: EditText = findViewById(R.id.txt_numMulheres)
        val numeroCriancas: EditText = findViewById(R.id.txt_numCriancas)
        val numeroBeberaoCerveja: EditText = findViewById(R.id.txt_numCerveja)
        val numeroBeberaoRefrigerante: EditText = findViewById(R.id.txt_numRefrigerante)

        val box_boi: CheckBox = findViewById(R.id.box_boi)
        val box_porco: CheckBox = findViewById(R.id.box_porco)
        val box_frango: CheckBox = findViewById(R.id.box_frango)
        val box_linguica: CheckBox = findViewById(R.id.box_linguica)

        btnCalcular.setOnClickListener {
            val homens = numeroHomens.text.toString().toIntOrNull() ?: 0
            val mulheres = numeroMulheres.text.toString().toIntOrNull() ?: 0
            val criancas = numeroCriancas.text.toString().toIntOrNull() ?: 0
            val cervejeiros = numeroBeberaoCerveja.text.toString().toIntOrNull() ?: 0
            val refrigeranteiros = numeroBeberaoRefrigerante.text.toString().toIntOrNull() ?: 0

            val totalCerveja = cervejeiros * 3.0

            val carnePorHomem = 0.35
            val carnePorMulher = 0.3
            val carnePorCrianca = 0.15

            val totalCarnes =
                (homens * carnePorHomem) + (mulheres * carnePorMulher) + (criancas * carnePorCrianca)

            var carneBoi = 0.0
            var carnePorco = 0.0
            var carneFrango = 0.0
            var carneLinguica = 0.0

            val checkedOptions = mutableListOf<Double>()

            if (box_boi.isChecked) {
                checkedOptions.add(0.5)
            }
            if (box_porco.isChecked) {
                checkedOptions.add(0.25)
            }
            if (box_frango.isChecked) {
                checkedOptions.add(0.2)
            }
            if (box_linguica.isChecked) {
                checkedOptions.add(0.2)
            }

            val totalPercent = checkedOptions.sum()

            if (totalPercent > 0) {
                if (box_boi.isChecked) {
                    carneBoi = totalCarnes * (0.5 / totalPercent)
                }
                if (box_porco.isChecked) {
                    carnePorco = totalCarnes * (0.25 / totalPercent)
                }
                if (box_frango.isChecked) {
                    carneFrango = totalCarnes * (0.2 / totalPercent)
                }
                if (box_linguica.isChecked) {
                    carneLinguica = totalCarnes * (0.2 / totalPercent)
                }
            } else {
                Toast.makeText(this, "Selecione pelo menos uma carne!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val totalRefrigerante = refrigeranteiros * 0.6

            val tipoCarne = mutableListOf<String>()
            if (box_boi.isChecked) tipoCarne.add("Boi")
            if (box_porco.isChecked) tipoCarne.add("Porco")
            if (box_frango.isChecked) tipoCarne.add("Frango")
            if (box_linguica.isChecked) tipoCarne.add("Linguiça")

            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("TOTAL_CARNE", totalCarnes)
            intent.putExtra("TOTAL_CERVEJA", totalCerveja)
            intent.putExtra("TOTAL_REFRIGERANTE", totalRefrigerante)
            intent.putExtra("CARNE_BOI", carneBoi)
            intent.putExtra("CARNE_PORCO", carnePorco)
            intent.putExtra("CARNE_FRANGO", carneFrango)
            intent.putExtra("CARNE_LINGUICA", carneLinguica)

            startActivity(intent)
        }
    }
}
