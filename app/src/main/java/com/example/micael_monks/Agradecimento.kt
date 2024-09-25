package com.example.micael_monks

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.micael_monks.databinding.ActivityAgradecimentoBinding

class Agradecimento : AppCompatActivity() {

    private lateinit var binding: ActivityAgradecimentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usando ViewBinding
        binding = ActivityAgradecimentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Exibir tela em full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Listener para o botão de voltar ao login
        binding.backBtn.setOnClickListener {
            // Intent para voltar à tela de login
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish() // Finaliza a activity atual
        }
    }
}
