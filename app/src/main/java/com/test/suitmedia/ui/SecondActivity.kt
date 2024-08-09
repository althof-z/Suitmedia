package com.test.suitmedia.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.test.suitmedia.databinding.ActivitySecondBinding
import com.test.suitmedia.data.model.User

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    private val resultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val user: User? = data?.getParcelableExtra(ThirdActivity.RESULT_KEY_USER)
                if (user != null) {
                    // Handle the received user data
                    binding.tvSelectedUsername.text = "${user.firstName} ${user.lastName}"
                    Toast.makeText(this, "Received user: ${user.firstName}", Toast.LENGTH_SHORT).show()
                }
            }
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
        val intent = Intent(this, ThirdActivity::class.java)
        resultLauncher.launch(intent)
    }
}
