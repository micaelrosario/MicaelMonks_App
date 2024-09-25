package com.example.micael_monks

import android.content.Intent
import android.database.Cursor
//import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.micael_monks.databinding.ActivityConfirmacaoDadosBinding
import com.example.micael_monks.databinding.ActivityLoginBinding

//import com.example.micael_monks.DatabaseHelper
//import android.widget.Toast

class ConfirmacaoDados : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmacaoDadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usando ViewBinding
        binding = ActivityConfirmacaoDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Exibir tela em full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
/*
        // Inicialize o DatabaseHelper
        dbHelper = DatabaseHelper(this)
        db = dbHelper.readableDatabase

        // Aqui você deve garantir que o username esteja sendo passado corretamente
        val username = intent.getStringExtra("USERNAME")
        if (username != null) {
            getUserData(username)
        } else {

            Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_SHORT).show()
        }
*/
        // Listener para o botão "Finalizar"
        binding.btnFinalizar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
/*
    // Função para buscar os dados do usuário no banco
    private fun getUserData(username: String) {
        val query = "SELECT * FROM Users WHERE reg_username = ?"
        val cursor: Cursor = db.rawQuery(query, arrayOf(username))

        if (cursor.moveToFirst()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow("reg_name"))
            val username = cursor.getString(cursor.getColumnIndexOrThrow("reg_username"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("reg_email"))
            val phone = cursor.getString(cursor.getColumnIndexOrThrow("reg_phone"))


            // Exibe os dados na tela
            binding.valueNomeCompleto.text = "Nome Completo: $name"
            binding.valueUsuario.text = "Usuário: $username"
            binding.valueEmail.text = "E-mail: $email"
            binding.valueNumeroTelefone.text = "Número de Telefone: $phone"
        }

        cursor.close()

    }

    override fun onDestroy() {
        super.onDestroy()
        db.close() // Fechar o banco de dados ao destruir a Activity
    }*/
}
