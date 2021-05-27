package com.example.mytestkmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytestkmm.Greeting
import android.widget.TextView
import com.example.mytestkmm.DatabaseDriverFactory
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


private  val mainScope=MainScope()
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val greeting=Greeting(DatabaseDriverFactory(applicationContext))
        val tv: TextView = findViewById(R.id.text_view)
        tv.text="loading..."
        mainScope.launch {
            kotlin.runCatching {
                greeting.greeting()
            }.onSuccess {
                tv.text = it
            }.onFailure {
                tv.text = "Error: ${it.localizedMessage}"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
