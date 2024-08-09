package com.test.suitmedia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.suitmedia.databinding.ActivityMainBinding
import com.test.suitmedia.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, ThirdActivity::class.java))
        }
    }

    private val binding: ActivityThirdBinding by lazy {
        ActivityThirdBinding.inflate(
            layoutInflater
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



    }

//    private fun setupUserRV(){
//        binding.rvUser.apply {
//            adapter = animeAdapter
//            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
//            itemAnimator = DefaultItemAnimator()
//        }
//    }
}