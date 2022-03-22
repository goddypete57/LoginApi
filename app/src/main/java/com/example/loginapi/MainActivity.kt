package com.example.loginapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.loginapi.databinding.ActivityMainBinding
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        "https://jsonplaceholder.typicode.com/posts".httpGet()
            .responseString{request, response, result ->
            result.fold({
                binding.textid.text =it
            },{
            })

            }
        val body =
            """
               {
                    "user":"10",
                    "id":"96",
                    "title":"api",
               }
            """
        "https://jsonplaceholder.typicode.com/posts".httpPost()
            .body(body)
            .responseString { _, _, result ->
                result.fold({
                    Log.d("MainActivity","successful")
                },{

                })

            }
    }
}