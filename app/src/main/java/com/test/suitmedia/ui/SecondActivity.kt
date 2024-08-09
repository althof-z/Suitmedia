package com.test.suitmedia.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.suitmedia.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(
            layoutInflater
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("EXTRA_NAME")

        binding.tvLoginUsername.text = name
        binding.btnChooseUser.setOnClickListener {
            openThirdActivity()
        }
    }

    private fun openThirdActivity() {
        ThirdActivity.startActivity(this)
    }
}