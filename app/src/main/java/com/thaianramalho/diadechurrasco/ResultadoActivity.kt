package com.thaianramalho.diadechurrasco

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val totalCarne = intent.getDoubleExtra("TOTAL_CARNE", 0.0)
        val totalCerveja = intent.getDoubleExtra("TOTAL_CERVEJA", 0.0)
        val totalRefrigerante = intent.getDoubleExtra("TOTAL_REFRIGERANTE", 0.0)
        val carneBoi = intent.getDoubleExtra("CARNE_BOI", 0.0)
        val carnePorco = intent.getDoubleExtra("CARNE_PORCO", 0.0)
        val carneFrango = intent.getDoubleExtra("CARNE_FRANGO", 0.0)
        val carneLinguica = intent.getDoubleExtra("CARNE_LINGUICA", 0.0)

        val gramasSalGrosso = 5 // por kg de carne
        val qtdCopos = (totalCerveja * 1.5)// um copo e meio por lata de cerveja
        val qtdSalGrosso = (gramasSalGrosso * totalCarne)
        val qtdCarvao = (1.5 * totalCarne)// 1.5kg de carvão por kg de carne
        val gramasTempero  = (40 * totalCarne) // 40g de condimentos para cada kg de carne


        val txtTotalCarne: TextView = findViewById(R.id.txt_totalCarne)
        val txtTotalCerveja: TextView = findViewById(R.id.txt_totalCerveja)
        val txtTotalRefrigerante: TextView = findViewById(R.id.txt_totalRefrigerante)
        val txtCarneBoi: TextView = findViewById(R.id.txt_resultado_boi)
        val txtCarnePorco: TextView = findViewById(R.id.txt_resultado_porco)
        val txtCarneFrango: TextView = findViewById(R.id.txt_resultado_frango)
        val txtCarneLinguica: TextView = findViewById(R.id.txt_resultado_linguica)
        val txtSalGrosso: TextView = findViewById(R.id.txt_sal_grosso)
        val txtCopos: TextView = findViewById(R.id.txt_copos)
        val txtCarvao: TextView = findViewById(R.id.txt_carvao)
        val txtTempero: TextView = findViewById(R.id.txt_tempero)


        txtTotalCarne.text = "Total de carne: %.2f kg".format(totalCarne)
        txtTotalCerveja.text = "Total de cerveja: %.0f latas".format(totalCerveja)
        txtTotalRefrigerante.text = "Total de refrigerante: %.1f L".format(totalRefrigerante)
        txtCarneBoi.text = String.format("Carne de Boi: %.2f kg", carneBoi)
        txtCarnePorco.text = String.format("Carne de Porco: %.2f kg", carnePorco)
        txtCarneFrango.text = String.format("Carne de Frango: %.2f kg", carneFrango)
        txtCarneLinguica.text = String.format("Linguiça: %.2f kg", carneLinguica)
        txtSalGrosso.text = String.format("Sal grosso: %.1f gramas", qtdSalGrosso)
        txtCopos.text = String.format("Copos: %.0f unidade(s)", qtdCopos)
        txtCarvao.text = String.format("Carvão: %.1f kg", qtdCarvao)
        txtTempero.text = String.format("Tempero: %.0f gramas", gramasTempero)
    }
}
