package com.example.flavorsdemo.feature.userlist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flavorsdemo.R
import com.example.flavorsdemo.databinding.ActivityUserBinding
import com.example.flavorsdemo.feature.userlist.presentation.adapter.UserAdapter
import com.example.flavorsdemo.feature.userlist.presentation.userVO.UserVo
import com.example.flavorsdemo.feature.userlist.presentation.userVO.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserBinding
    private val viewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        val adapter = UserAdapter()
        binding.userListRV.adapter  = adapter
        binding.userListRV.layoutManager = LinearLayoutManager(this)

        viewModel.userView.observe(this) {
            Log.d("Activity", it.toString())
            adapter.users = (it as? UserVo.Loaded)?.users ?: emptyList()

        }
    }
}