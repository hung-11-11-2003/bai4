package com.example.booklist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booklist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Danh sách sách
        val books = listOf(
            Book("Book Title 1", "Author 1"),
            Book("Book Title 2", "Author 2"),
            Book("Book Title 3", "Author 3"),
            Book("Book Title 4", "Author 4"),
            Book("Book Title 5", "Author 5")
        )

        // Thiết lập RecyclerView
        bookAdapter = BookAdapter(books)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = bookAdapter
    }
}
