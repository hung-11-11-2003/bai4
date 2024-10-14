package com.example.a2_animationdemo

import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.transition.TransitionManager

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var button: Button
    private lateinit var constraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)
        constraintLayout = findViewById(R.id.constraintLayout)

        // Animation cho Button
        button.setOnClickListener {
            // Property Animation: Thay đổi kích thước, màu sắc và vị trí của TextView
            ObjectAnimator.ofFloat(textView, "scaleX", 1.5f).apply {
                duration = 500
                start()
            }
            ObjectAnimator.ofFloat(textView, "scaleY", 1.5f).apply {
                duration = 500
                start()
            }
            textView.setTextColor(Color.RED)

            // Transition Animation: Di chuyển vị trí của Button và TextView
            TransitionManager.beginDelayedTransition(constraintLayout)
            val layoutParams = button.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.horizontalBias = 0.8f  // Di chuyển sang bên phải
            button.layoutParams = layoutParams

            // Drawable Animation: Hiệu ứng chuyển đổi hình ảnh
            imageView.setBackgroundResource(R.drawable.animated_image)
            val animationDrawable = imageView.background as AnimationDrawable
            animationDrawable.start()
        }
    }
}
