package com.example.flavorsdemo.feature.userlist.presentation.adapter

import android.annotation.SuppressLint
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.flavorsdemo.databinding.ItemUserBinding
import com.example.flavorsdemo.feature.userlist.domain.entity.UserEntity
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class UserVH(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SimpleDateFormat")
    fun bind(userEntity: UserEntity) {


        binding.tvName.text = userEntity.name
        val targetedFormat = SimpleDateFormat("dd MMM yy HH:mm")
        var convertedString: String = ""
        if (userEntity.date.contains("T")) {
            val originalFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
            val date = originalFormat.parse(userEntity.date)
            convertedString = targetedFormat.format(date!!.time)
        } else {
            convertedString = targetedFormat.format(Date(userEntity.date.toLong()))

        }
        binding.tvDate.text = convertedString
        binding.tvStatus.text = userEntity.state
    }
}