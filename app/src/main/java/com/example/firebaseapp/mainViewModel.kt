package com.example.firebaseapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class mainViewModel(val context:Context):ViewModel() {
    private var quotes: Array<Quote> = emptyArray()
    private var index: Int = 0

    init {
        quotes = quotesFromAssets()
    }

    private fun quotesFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val length:Int = inputStream.available()
        val buffer = ByteArray(length)
        inputStream.read(buffer)
        inputStream.close()
        val json= String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json,Array<Quote>::class.java)
    }
    fun getQuote() = quotes[index]
    fun nextQuote() = quotes[++index]
    fun previousQuote() = quotes[--index]
}