package com.test.suitmedia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.test.suitmedia.databinding.ActivitySecondBinding
import com.test.suitmedia.databinding.ActivityThirdBinding

class SecondActivity : AppCompatActivity() {
    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, SecondActivity::class.java))
        }
    }

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(
            layoutInflater
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}