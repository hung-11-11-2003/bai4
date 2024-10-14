package com.example.responsiveui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val productList = listOf(
            Product("Product 1", 19.99),
            Product("Product 2", 29.99),
            Product("Product 3", 39.99),
            Product("Product 4", 49.99),
            Product("Product 5", 59.99)
        )

        productAdapter = ProductAdapter(productList)
        recyclerView.adapter = productAdapter

        // Thiết lập LayoutManager phù hợp
        if (resources.configuration.smallestScreenWidthDp >= 600) {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        } else {
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }
}
