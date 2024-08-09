package com.test.suitmedia.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.test.suitmedia.data.model.User

class UserDiffUtil : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        // Assuming each user has a unique email, or you can add an ID property in the User model.
        return oldItem.email == newItem.email
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        // Compare all properties to ensure correct diffing.
        return oldItem == newItem
    }
}
