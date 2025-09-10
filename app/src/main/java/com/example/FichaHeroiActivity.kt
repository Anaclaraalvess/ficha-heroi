package com.example.heroficha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.fichadesuper_heri.R

class FichaHeroiActivity : AppCompatActivity() {

    private lateinit var ivAvatarFicha: ImageView
    private lateinit var tvCodinome: TextView
    private lateinit var tvAlinhamento: TextView
    private lateinit var tvPoderesLista: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_heroi)

        // Inicializa as views
        ivAvatarFicha = findViewById(R.id.iv_avatar_ficha)
        tvCodinome = findViewById(R.id.tv_codinome)
        tvAlinhamento = findViewById(R.id.tv_alinhamento)
        tvPoderesLista = findViewById(R.id.tv_poderes_lista)

        // Recebe os dados da Intent
        val codinome = intent.getStringExtra("EXTRA_CODIINOME") ?: "Não informado"
        val alinhamento = intent.getStringExtra("EXTRA_ALINHAMENTO") ?: "Não informado"
        val poderes = intent.getStringArrayListExtra("EXTRA_PODERES") ?: arrayListOf()
        val avatarId = intent.getIntExtra("EXTRA_AVATAR_ID", R.drawable.ic_launcher_foreground)

        // Preenche a UI com os dados recebidos
        ivAvatarFicha.setImageResource(avatarId)
        tvCodinome.text = codinome
        tvAlinhamento.text = alinhamento
        tvPoderesLista.text = poderes.joinToString(separator = ", ")

        // Define o título da Activity
        title = "Ficha de $codinome"
    }

    }
