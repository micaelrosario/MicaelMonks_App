package com.example.micael_monks  // Certifique-se de que o pacote corresponda ao seu projeto

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "your_database_name.db" // Nome do banco de dados
        private const val DATABASE_VERSION = 1 // Versão do banco de dados
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Crie suas tabelas aqui
        val createTable = "CREATE TABLE Users (id INTEGER PRIMARY KEY AUTOINCREMENT, reg_name TEXT, reg_username TEXT, reg_email TEXT, reg_phone TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Lógica para atualizar o banco de dados
        db.execSQL("DROP TABLE IF EXISTS Users")
        onCreate(db)
    }
}
