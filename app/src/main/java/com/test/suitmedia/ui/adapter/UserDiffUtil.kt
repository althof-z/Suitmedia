package com.test.suitmedia.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.test.suitmedia.data.model.User

class UserDiffUtil : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.email == newItem.email
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}
