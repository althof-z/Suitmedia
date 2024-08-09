package com.test.suitmedia.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.test.suitmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        setStatusBar()

        activityMainBinding.btnNext.setOnClickListener {
            handleNextButtonClick()
        }

        activityMainBinding.btnCheck.setOnClickListener {
            handleCheckButtonClick()
        }
    }

    private fun handleNextButtonClick() {
        val name = activityMainBinding.edtName.text.toString()
        if (name.isEmpty()) {
            activityMainBinding.edtName.error = "Tidak Boleh kosong"
        } else {
            openSecondActivity(name)
        }
    }

    private fun handleCheckButtonClick() {
        val inputText = activityMainBinding.edtPalindrome.text.toString()
        if (inputText.isEmpty()) {
            activityMainBinding.edtPalindrome.error = "Tidak Boleh kosong"
        } else {
            val message = if (isPalindrome(inputText)) "is palindrome" else "not palindrome"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun openSecondActivity(name: String) {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("EXTRA_NAME", name)
        }
        startActivity(intent)
    }

    private fun isPalindrome(input: String): Boolean {
        val cleanedInput = input.replace("\\s+".toRegex(), "").lowercase()
        return cleanedInput == cleanedInput.reversed()
    }

    fun setStatusBar(){
        WindowCompat.setDecorFitsSystemWindows(
            window,
            false
        )
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}
