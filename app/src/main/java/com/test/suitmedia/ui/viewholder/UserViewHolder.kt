package com.test.suitmedia.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.test.suitmedia.data.model.User
import com.test.suitmedia.databinding.ItemUserBinding
import com.test.suitmedia.ui.adapter.UserAdapterListener

class UserViewHolder(
    private val binding: ItemUserBinding, private val userAdapterListener: UserAdapterListener
): RecyclerView.ViewHolder(binding.root) {

    fun bindUser(data: User){
        binding.tvFName.text = data.firstName

        binding.tvLName.text = data.lastName

        binding.tvEmail.text = data.email

        binding.ivUser.load(data.avatar)

        binding.root.setOnClickListener{ userAdapterListener.onClickUser(data)}
    }
}