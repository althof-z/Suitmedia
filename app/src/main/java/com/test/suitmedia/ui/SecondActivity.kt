package com.test.suitmedia.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.test.suitmedia.R
import com.test.suitmedia.databinding.ActivitySecondBinding
import com.test.suitmedia.data.model.User

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    private val resultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val user: User? = result.data?.getParcelableExtra(ThirdActivity.RESULT_KEY_USER)
                user?.let {
                    binding.tvSelectedUsername.text = "${it.firstName} ${it.lastName}"
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupTitleAndNavigation()
        binding.tvLoginUsername.text = intent.getStringExtra("EXTRA_NAME")

        binding.btnChooseUser.setOnClickListener {
            openThirdActivity()
        }
    }

    fun setupTitleAndNavigation() {
        val buttonNavigateUp = findViewById<ImageView>(R.id.imgBackArrow)
        buttonNavigateUp.setOnClickListener{finish()}
    }

    private fun openThirdActivity() {
        val intent = Intent(this, ThirdActivity::class.java)
        resultLauncher.launch(intent)
    }
}
