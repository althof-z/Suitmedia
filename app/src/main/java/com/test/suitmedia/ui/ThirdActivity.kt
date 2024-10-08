package com.test.suitmedia.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.suitmedia.R
import com.test.suitmedia.databinding.ActivityThirdBinding
import com.test.suitmedia.data.model.User
import com.test.suitmedia.ui.adapter.UserAdapter
import com.test.suitmedia.ui.adapter.UserAdapterListener

class ThirdActivity : AppCompatActivity(), UserAdapterListener {

    companion object {
        const val RESULT_KEY_USER = "RESULT_KEY_USER"
    }

    private val viewModel by viewModels<ThirdActivityViewModel> {
        ThirdActivityViewModel.provideFactory(this, this)
    }

    private val userAdapter = UserAdapter(this)
    private val binding: ActivityThirdBinding by lazy {
        ActivityThirdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupTitleAndNavigation()
        setupRecyclerView()
        setStatusBar()

        viewModel.retrieveUsers()
        viewModel.users.observe(this) { users ->
            userAdapter.submitList(users)
        }
        viewModel.loading.observe(this) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
        viewModel.error.observe(this) { error ->
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupTitleAndNavigation() {
        val buttonNavigateUp = findViewById<ImageView>(R.id.imgBackArrow)
        buttonNavigateUp.setOnClickListener{finish()}
    }

    private fun setupRecyclerView() {
        binding.rvUser.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }
    }

    override fun onClickUser(data: User) {
        setResult(RESULT_OK, Intent().apply {
            putExtra(RESULT_KEY_USER, data)
        })
        finish()
    }

    fun setStatusBar(){
        WindowCompat.setDecorFitsSystemWindows(
            window,
            false
        )
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}
