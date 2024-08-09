package com.test.suitmedia.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.test.suitmedia.data.model.User
import com.test.suitmedia.databinding.ItemUserBinding
import com.test.suitmedia.ui.viewholder.UserViewHolder

class UserAdapter(
    private val userAdapterListener: UserAdapterListener,
): ListAdapter<User, UserViewHolder>(UserDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        Log.d("UserAdapter", "onCreateViewHolder called")
        return UserViewHolder(
            binding = ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            userAdapterListener = userAdapterListener,
        )
    }

    override fun getItemCount(): Int {
        Log.d("UserAdapter", "getItemCount: ${currentList.size}")
        return currentList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        Log.d("BINDINGGGG", "Binding user at position $position")
        try {
            holder.bindUser(getItem(position))
        }catch (e: Exception){
            Log.d("ERORO", e.toString())
        }

    }

}