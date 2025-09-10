package com.example.heroficha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import com.example.fichadesuper_heri.R

class CriacaoHeroiActivity : AppCompatActivity() {

    private lateinit var tvBemVindo: TextView
    private lateinit var rgAlinhamento: RadioGroup
    private lateinit var cbVoo: CheckBox
    private lateinit var cbSuperForca: CheckBox
    private lateinit var cbTelepatia: CheckBox
    private lateinit var cbRajadasEnergia: CheckBox
    private lateinit var cbSuperVelocidade: CheckBox
    private lateinit var ivAvatarSeletor: ImageView
    private lateinit var btnGerarFicha: Button

    // Lista de avatares (adicione seus próprios avatares na pasta res/drawable)
    private val avatares = arrayOf(
        R.drawable.avatar1,
        R.drawable.avatar2,
        R.drawable.avatar3
    )
    private var avatarIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criacao_heroi)

        // Inicializa as views
        tvBemVindo = findViewById(R.id.tv_bem_vindo)
        rgAlinhamento = findViewById(R.id.rg_alinhamento)
        cbVoo = findViewById(R.id.cb_voo)
        cbSuperForca = findViewById(R.id.cb_super_forca)
        cbTelepatia = findViewById(R.id.cb_telepatia)
        cbRajadasEnergia = findViewById(R.id.cb_rajadas_energia)
        cbSuperVelocidade = findViewById(R.id.cb_super_velocidade)
        ivAvatarSeletor = findViewById(R.id.iv_avatar_seletor)
        btnGerarFicha = findViewById(R.id.btn_gerar_ficha)

        // Recebe o codinome da tela anterior e exibe
        val codinome = intent.getStringExtra("EXTRA_CODIINOME") ?: "Herói Anônimo"
        tvBemVindo.text = "Personalize o perfil de: $codinome"

        // Configura o seletor de avatar
        ivAvatarSeletor.setOnClickListener {
            // Avança para o próximo avatar na lista
            avatarIndex = (avatarIndex + 1) % avatares.size
            ivAvatarSeletor.setImageResource(avatares[avatarIndex])
        }

        // Configura o listener do botão
        btnGerarFicha.setOnClickListener {
            // Coleta todas as informações
            val alinhamento = when (rgAlinhamento.checkedRadioButtonId) {
                R.id.rb_heroi -> "Herói"
                R.id.rb_vilao -> "Vilão"
                R.id.rb_antiheroi -> "Anti-herói"
                else -> "Não definido"
            }

            val poderes = arrayListOf<String>()
            if (cbVoo.isChecked) poderes.add("Voo")
            if (cbSuperForca.isChecked) poderes.add("Super-força")
            if (cbTelepatia.isChecked) poderes.add("Telepatia")
            if (cbRajadasEnergia.isChecked) poderes.add("Rajadas de Energia")
            if (cbSuperVelocidade.isChecked) poderes.add("Super-velocidade")

            // Cria a Intent para a próxima tela e passa os dados
            val intent = Intent(this, FichaHeroiActivity::class.java).apply {
                putExtra("EXTRA_CODIINOME", codinome)
                putExtra("EXTRA_ALINHAMENTO", alinhamento)
                putStringArrayListExtra("EXTRA_PODERES", poderes)
                putExtra("EXTRA_AVATAR_ID", avatares[avatarIndex])
            }
            startActivity(intent)
        }
    }

    class FichaHeroiActivity(activity: CriacaoHeroiActivity, java: Any) {

    }
}