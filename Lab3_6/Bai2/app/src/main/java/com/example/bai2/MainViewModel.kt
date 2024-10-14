package com.example.bai2

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _seconds = MutableLiveData(0)
    val seconds: LiveData<Int> get() = _seconds

    private var _isRunning = MutableLiveData(false)
    val isRunning: LiveData<Boolean> get() = _isRunning

    private var timer: CountDownTimer? = null

    // Khởi động hoặc tạm dừng bộ đếm
    fun startPauseTimer() {
        if (_isRunning.value == true) {
            pauseTimer()
        } else {
            startTimer()
        }
    }

    private fun startTimer() {
        _isRunning.value = true
        timer = object : CountDownTimer(Long.MAX_VALUE, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _seconds.value = _seconds.value?.plus(1)
            }

            override fun onFinish() {}
        }.start()
    }

    private fun pauseTimer() {
        _isRunning.value = false
        timer?.cancel()
    }

    fun resetTimer() {
        pauseTimer()
        _seconds.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }

    fun setSeconds(value: Int) {
        _seconds.value = value
    }
}