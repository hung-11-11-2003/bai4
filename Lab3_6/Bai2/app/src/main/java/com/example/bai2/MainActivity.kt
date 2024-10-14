package com.example.bai2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.bai2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Quan sát giá trị thời gian
        viewModel.seconds.observe(this, Observer { seconds ->
            binding.tvTimer.text = seconds.toString()
        })

        // Quan sát trạng thái của bộ đếm
        viewModel.isRunning.observe(this, Observer { isRunning ->
            binding.btnStartPause.text = if (isRunning) "Pause" else "Start"
        })

        // Xử lý nút Start/Pause
        binding.btnStartPause.setOnClickListener {
            viewModel.startPauseTimer()
        }

        // Xử lý nút Reset
        binding.btnReset.setOnClickListener {
            viewModel.resetTimer()
        }

        // Khôi phục trạng thái nếu có
        if (savedInstanceState != null) {
            val savedSeconds = savedInstanceState.getInt("seconds", 0)
            viewModel.setSeconds(savedSeconds)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("seconds", viewModel.seconds.value ?: 0)
    }
}
