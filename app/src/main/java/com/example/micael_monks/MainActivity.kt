package com.example.micael_monks

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.content.Intent
import android.view.WindowManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.util.Pair
import androidx.core.app.ActivityOptionsCompat
import com.example.micael_monks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Variável de binding
    private lateinit var binding: ActivityMainBinding

    // Variáveis para as animações
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Use binding.root em vez de R.layout.activity_main

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Aplicar insets ao layout principal
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializando as animações
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        // Definindo animações
        binding.imageView.startAnimation(topAnim)
        binding.logoText.startAnimation(bottomAnim)
        binding.sloganText.startAnimation(bottomAnim)

        // Usando Handler para atraso de 3,5 segundos e iniciar a próxima Activity com animação
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Login::class.java)

            // Usando Pair para as animações de transição
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                Pair(binding.imageView as View, "img_carro"),
                Pair(binding.logoText as View, "logo_text")
            )

            startActivity(intent, options.toBundle())
        }, 3500) // 3,5 segundos de delay
    }
}
