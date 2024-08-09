package com.test.suitmedia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.test.suitmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(
            layoutInflater
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnNext.setOnClickListener{ openSecondActivity()}
        activityMainBinding.btnCheck.setOnClickListener{openThirdActivity()}
    }

    private fun openThirdActivity() {
        ThirdActivity.startActivity(this)
    }
    private fun openSecondActivity() {
        SecondActivity.startActivity(this)
    }
}