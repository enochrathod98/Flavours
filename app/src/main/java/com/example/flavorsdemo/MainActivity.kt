package com.example.flavorsdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.flavorsdemo.databinding.ActivityMainBinding
import com.example.flavorsdemo.databinding.ActivityUserBinding
import com.example.flavorsdemo.feature.applicationtype.presentation.applicationTypeVO.ApplicationTypeVO
import com.example.flavorsdemo.feature.applicationtype.presentation.viewmodel.ApplicationTypeViewModel
import com.example.flavorsdemo.feature.userlist.presentation.UserActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<ApplicationTypeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvBuildType.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }

        viewModel.viewType.observe(this) {
            binding.tvBuildType.text = (it as? ApplicationTypeVO.Loaded)?.applicationType?.name
        }
        binding.root.setBackgroundColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.background
            )
        )
    }
}