package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.viewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainviewmodel: mainViewModel
    val AuthorName:TextView = findViewById(R.id.author)
    val QuoteText:TextView = findViewById(R.id.quote)
    val nextbtn:Button=findViewById(R.id.nextBtn)
    val prevbtn:Button=findViewById(R.id.prevBtn)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainviewmodel = ViewModelProvider(this,ViewModelFactory(application)).get()
        setQuote(mainviewmodel.getQuote())

        prevbtn.setOnClickListener {
            setQuote(mainviewmodel.nextQuote())
        }


        nextbtn.setOnClickListener {
            setQuote(mainviewmodel.previousQuote())
        }
    }

    private fun setQuote(quote: Quote){
        QuoteText.text = quote.text
        AuthorName.text = quote.author
    }

}