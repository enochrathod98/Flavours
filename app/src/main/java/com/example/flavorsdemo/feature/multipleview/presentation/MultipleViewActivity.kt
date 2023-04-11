package com.example.flavorsdemo.feature.multipleview.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flavorsdemo.databinding.ActivityMultipleViewBinding
import com.example.flavorsdemo.feature.multipleview.presentation.adapter.MultipleViewAdapter
import com.example.flavorsdemo.feature.multipleview.presentation.multipleviewVO.MultipleViewVO
import com.example.flavorsdemo.feature.multipleview.presentation.multipleviewVO.viewmodel.MultipleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MultipleViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityMultipleViewBinding
    private val viewModel by viewModels<MultipleViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultipleViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val adapter = MultipleViewAdapter()
        binding.multipleViewRv.adapter = adapter
        binding.multipleViewRv.layoutManager = LinearLayoutManager(this)

        viewModel.dataView.observe(this) {
            Log.d("Activity", it.toString())
            adapter.items = (it as? MultipleViewVO.Loaded)?.users ?: emptyList()
        }
    }
}