package com.example.animationdemo

import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.transition.TransitionManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Property Animation
        val btnAnimate = findViewById<Button>(R.id.btnAnimate)
        btnAnimate.setOnClickListener {
            // Thay đổi vị trí của button
            ObjectAnimator.ofFloat(btnAnimate, "translationX", 300f).apply {
                duration = 1000
                start()
            }
            // Thay đổi kích thước của button
            ObjectAnimator.ofFloat(btnAnimate, "scaleX", 2f).apply {
                duration = 1000
                start()
            }
            // Thay đổi màu nền của button
            btnAnimate.setBackgroundColor(Color.RED)
        }

        // Drawable Animation
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setBackgroundResource(R.drawable.animated_button)

        val animationDrawable = imageView.background as AnimationDrawable
        imageView.setOnClickListener {
            // Bắt đầu hiệu ứng chuyển đổi hình ảnh
            animationDrawable.start()
        }

        // Transition Animation
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val btnAnimateTransition = findViewById<Button>(R.id.btnAnimateTransition)

        btnAnimateTransition.setOnClickListener {
            // Bắt đầu hiệu ứng chuyển cảnh
            TransitionManager.beginDelayedTransition(constraintLayout)
            // Thay đổi vị trí và kích thước của button
            btnAnimateTransition.layoutParams.width = 500
            btnAnimateTransition.requestLayout()
        }
    }
}
