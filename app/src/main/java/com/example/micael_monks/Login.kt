package com.example.micael_monks

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.micael_monks.databinding.ActivityLoginBinding
import android.database.sqlite.SQLiteDatabase
import android.os.Environment
import java.io.File


class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var db: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usando ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        // Listener para o botão de ir para a tela de cadastro
        binding.signup.setOnClickListener {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }


        // Listener para o botão de login
        binding.comecar.setOnClickListener {
            validateLogin()
        }

        // Abrir o banco de dados (o mesmo utilizado na tela de cadastro)
        val folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString() + "/Database"
        val myFile = File(folder, "Cadastro.db")
        db = SQLiteDatabase.openDatabase(myFile.absolutePath, null, SQLiteDatabase.OPEN_READONLY)
    }

    private fun validateLogin() {
        val username = binding.username.editText?.text.toString()
        val password = binding.password.editText?.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {
            val query = "SELECT * FROM Users WHERE username = ? AND password = ?"
            val cursor = db?.rawQuery(query, arrayOf(username, password))

            if (cursor != null && cursor.count > 0) {
                cursor.moveToFirst()
                Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_LONG).show()

                // Redirecionar para a próxima tela após o login
                val intent = Intent(this, ConfirmacaoDados::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_LONG).show()
            }
            cursor?.close()
        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_LONG).show()
        }
    }
}
