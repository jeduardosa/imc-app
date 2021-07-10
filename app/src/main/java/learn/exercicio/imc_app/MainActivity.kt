package learn.exercicio.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setListners()

    buttonCalcular.setOnClickListener() {

        if (editPeso.text!!.isBlank()) {
            Toast.makeText(this, "Preencha o campo Peso", Toast.LENGTH_SHORT).show()

        }
        if (editAltura.text!!.isBlank()){
            Toast.makeText(this, "Preencha o campo Altura", Toast.LENGTH_SHORT).show()
        }
    }

    }

    private fun setListners() {

        buttonCalcular?.setOnClickListener() {
            calcularIMC(editPeso.text.toString(), editAltura.text.toString())
        }
    }

    fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        var nivelIMC: String
        val imc: Float

        if (peso != null && altura != null) {
            imc = peso!! / (altura!! * altura!!)

            if (imc < 18.5) {
                textImc.text = "Seu IMC é: " + String.format("%.2f", imc) + "\nabaixo do peso"
            } else if (imc > 18.5 && imc < 24.9) {
                textImc.text = "Seu IMC é: " + String.format("%.2f", imc) + "\npeso normal"
            } else if (imc < 25 && imc < 29.9) {
                textImc.text = "Seu IMC é: " + String.format("%.2f", imc) + "\nSobrepeso"
            } else if (imc < 30 && imc < 34.9) {
                textImc.text = "Seu IMC é: " + String.format("%.2f", imc) + "\nObesidade grau I"
            } else if (imc < 35 && imc < 39.9) {
                textImc.text = "Seu IMC é: " + String.format("%.2f", imc) + "\nObesidade grau II"
            } else if (imc >= 40) {
                textImc.text = "Seu IMC é: " + String.format("%.2f", imc) + "\nObesidade grau III"
            }
        }
    }


}