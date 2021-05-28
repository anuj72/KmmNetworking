package com.example.mytestkmm.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mytestkmm.android.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.json.JSONObject

private val mainScope = MainScope()

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.users.observe(this) {
            val jsonString = Gson().toJson(it)
            val jsonObject = JSONObject(jsonString)

            val prettyJsonString = jsonObject.toString(2)
            binding.textView.text = prettyJsonString
        }
        /*val greeting = Greeting(DatabaseDriverFactory(applicationContext))
        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "loading..."
        mainScope.launch {
            kotlin.runCatching {
                greeting.greeting()
            }.onSuccess {
                tv.text = it
            }.onFailure {
                tv.text = "Error: ${it.localizedMessage}"
            }
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
