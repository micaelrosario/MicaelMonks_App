package com.example.micael_monks

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.micael_monks.databinding.ActivityCadastroBinding
import android.database.sqlite.SQLiteDatabase
import com.example.micael_monks.databinding.ActivityConfirmacaoDadosBinding
import java.io.File

class Cadastro : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private var db: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usando ViewBinding
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Criando o banco de dados e a tabela
        //createDb()

        // Definindo os listeners para os botões
        binding.regBtn.setOnClickListener {
            val nomeCompleto = binding.regName.editText?.text.toString()
            val usuario = binding.regUsername.editText?.text.toString()
            val email = binding.regEmail.editText?.text.toString()
            val telefone = binding.regPhone.editText?.text.toString()
            val senha = binding.regSenha.editText?.text.toString()

            // Enviar os dados para a tela de confirmação
            val intent = Intent(this, Agradecimento::class.java)
            intent.putExtra("nome_completo", nomeCompleto)
            intent.putExtra("usuario", usuario)
            intent.putExtra("email", email)
            intent.putExtra("telefone", telefone)
            intent.putExtra("senha", senha)
            startActivity(intent)
        }

        binding.regLoginBtn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
/*
    // Função para criar o banco de dados e a tabela de cadastro
    private fun createDb() {
        val folder = File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString() + "/Database")
        if (!folder.exists()) {
            folder.mkdir()
        }

        val myFile = File(folder, "Cadastro.db")
        db = SQLiteDatabase.openOrCreateDatabase(myFile.absolutePath, null)

        // Criando a tabela Users no banco de dados se não existir
        val createTableQuery = """
            CREATE TABLE IF NOT EXISTS Users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                username TEXT,
                email TEXT,
                phone TEXT,
                password TEXT
            );
        """.trimIndent()
        db?.execSQL(createTableQuery)
    }

    // Função para salvar os dados de cadastro no banco de dados
    private fun registerUser() {
        val name = binding.regName.editText?.text.toString()
        val username = binding.regUsername.editText?.text.toString()
        val email = binding.regEmail.editText?.text.toString()
        val phone = binding.regPhone.editText?.text.toString()
        val password = binding.regSenha.editText?.text.toString()

        // Verifica se os campos estão preenchidos
        if (name.isNotEmpty() && username.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty()) {
            val values = ContentValues().apply {
                put("name", name)
                put("username", username)
                put("email", email)
                put("phone", phone)
                put("password", password)
            }

            // Inserindo os dados no banco de dados
            db?.insert("Users", null, values)
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()

            // Redireciona para a tela de Login após o cadastro
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_LONG).show()
        }
    }*/


}