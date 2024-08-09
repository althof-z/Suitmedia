package com.test.suitmedia.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.suitmedia.data.model.User
import com.test.suitmedia.databinding.ActivityThirdBinding
import com.test.suitmedia.ui.adapter.UserAdapter
import com.test.suitmedia.ui.adapter.UserAdapterListener

class ThirdActivity : AppCompatActivity(), UserAdapterListener {
    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, ThirdActivity::class.java))
        }
    }

    private val userAdapter = UserAdapter(this)

    private val binding: ActivityThirdBinding by lazy {
        ActivityThirdBinding.inflate(
            layoutInflater
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupUserRV()
        // Load and submit the user list
        loadUsers()
    }

    private fun setupUserRV() {
        binding.rvUser.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    private fun loadUsers() {
        // Sample data, replace with your data-fetching logic
        val users = listOf(
            User(1, "","John", "Doe", "john@example.com"),
            User(2, "","Jane", "Smith", "jane@example.com"),
            User(3,"","Alice", "Johnson", "alice@example.com")
        )

        // Submit the list to the adapter
        userAdapter.submitList(users)
    }

    override fun onClickUser(data: User) {
        TODO("Not yet implemented")
    }
}