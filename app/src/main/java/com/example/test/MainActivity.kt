package com.example.test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        val listOfProduct = listOf<Product>(
            Product("Математика", 1000, 9),
            Product("Русский язык", 1100, 2),
            Product("Казахский язык", 1000, 3),
            Product("Математика", 1000, 4),
            Product("Литература", 1000, 5),
            Product("Алгебра", 1000, 6),
            Product("История", 1000, 7),
            Product("Математика", 1000, 1),
            Product("Английский", 1000, 3),
            Product("Математика", 1000, 10),
            Product("Физика", 1000, 5),
            Product("Биология", 1000, 8),
            Product("Химия", 1000, 11)
        )


        val adapter = ExampleRecyclerAdapter()

        binding.rcProducts.adapter = adapter
        adapter.submitList(listOfProduct)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}