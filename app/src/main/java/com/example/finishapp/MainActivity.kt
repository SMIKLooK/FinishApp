package com.example.finishapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finishapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityMainBinding

    private val PREFS_NAME = "MyPrefs"
    private val KEY_IS_FIRST_RUN = "isFirstRun"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        if (isFirstRun()) {
            binding.tv.text = "Hello World"
            setFirstRun(false)
        } else {
            binding.tv.text = "Pisa"
        }
    }

    private fun isFirstRun(): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_FIRST_RUN, true)
    }

    private fun setFirstRun(isFirstRun: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(KEY_IS_FIRST_RUN, isFirstRun)
        editor.apply()
    }
}