package com.example.micael_monks

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.content.Intent
import android.view.WindowManager
import android.view.View // Import necessário
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.util.Pair
import androidx.core.app.ActivityOptionsCompat

class MainActivity : AppCompatActivity() {

    // Variáveis para as animações e views
    lateinit var topAnim: Animation
    lateinit var bottomAnim: Animation
    lateinit var image: ImageView
    lateinit var logo: TextView
    lateinit var slogan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializando as animações
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        // Hooks para os elementos da UI
        image = findViewById(R.id.imageView)
        logo = findViewById(R.id.logo_text)
        slogan = findViewById(R.id.slogan_text)

        // Definindo animações
        image.startAnimation(topAnim)
        logo.startAnimation(bottomAnim)
        slogan.startAnimation(bottomAnim)

        // Usando Handler para atraso de 5 segundos e iniciar a próxima Activity com animação
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Login::class.java)

            // Usando Pair para as animações de transição
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                Pair(image as View, "img_carro"),
                Pair(logo as View, "logo_text")
            )

            startActivity(intent, options.toBundle())
        }, 3500) // 3 segundos de delay
    }
}
