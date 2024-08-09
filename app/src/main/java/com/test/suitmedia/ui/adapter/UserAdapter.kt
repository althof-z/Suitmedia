package com.test.suitmedia.ui.adapter

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
        return UserViewHolder(
            binding = ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            userAdapterListener = userAdapterListener,
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUser(getItem(position))
    }

}