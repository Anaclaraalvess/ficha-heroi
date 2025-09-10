package com.example.heroficha

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.fichadesuper_heri.R
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    private lateinit var etCodinome: EditText
    private lateinit var btnCriarPerfil: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa as views
        etCodinome = findViewById(R.id.et_codinome)
        btnCriarPerfil = findViewById(R.id.btn_criar_perfil)

        // Inicializa o SharedPreferences
        sharedPreferences = getSharedPreferences("HerofichaPrefs", Context.MODE_PRIVATE)

        // Verifica se há um codinome salvo e preenche o EditText
        val codinomeSalvo = sharedPreferences.getString("codinome", "")
        if (codinomeSalvo?.isNotEmpty() == true) {
            etCodinome.setText(codinomeSalvo)
        }

        // Configura o listener do botão
        btnCriarPerfil.setOnClickListener {
            val codinome = etCodinome.text.toString().trim()
            if (codinome.isNotEmpty()) {
                // Salva o codinome no SharedPreferences
                with(sharedPreferences.edit()) {
                    putString("codinome", codinome)
                    apply()
                }

                // Cria a Intent para a próxima tela e passa o codinome
                val intent = Intent(this, CriacaoHeroiActivity::class.java).apply {
                    putExtra("EXTRA_CODIINOME", codinome)
                }
                startActivity(intent)

            } else {
                etCodinome.error = "Por favor, insira um codinome."
            }
        }
    }

    private fun putExtra(string: String, codinome: String) {
        TODO("Not yet implemented")
    }
}

private fun MainActivity.startActivity(intent: Any) {
    TODO("Not yet implemented")
}

fun ERROR.apply(block: Any) {
    TODO("Not yet implemented")
}
