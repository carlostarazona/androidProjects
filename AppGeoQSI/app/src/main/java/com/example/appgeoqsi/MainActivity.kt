package com.example.appgeoqsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestons()
        setupViews()
    }

    fun loadQuestons() {
        questions = ArrayList()
        var question = Question("Es santigo capital de chile",true)
        questions.add(question)

         question = Question("Es Madrid capital de bolivia",false)
        questions.add(question)

        question = Question("Es la paz capital de bolivia",true)
        questions.add(question)
    }

    fun setupViews() {
       //1ra froma de vincular el boton del xml al codigo
       //val btYes = findViewById<Button>(R.id.btYes)
       //2ra froma de vincular el boton del xml al codigo

       btYes.setOnClickListener {
           Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
       }

       btNo.setOnClickListener {
           Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show()
       }

        btNext.setOnClickListener {
            position++
            showSentence()
        }
    }

    private fun showSentence() {
        tvSentences.text = questions[position].sentences
    }
}