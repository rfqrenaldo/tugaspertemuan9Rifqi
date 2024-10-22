    package com.example.tugaspertemuan9

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.tugaspertemuan9.databinding.ActivityMain3Binding
import com.example.tugaspertemuan9.databinding.ActivityMainBinding

    class MainActivity3 : AppCompatActivity() {
        private lateinit var binding: ActivityMain3Binding
        private lateinit var sharedViewModel: SharedViewModel


        override fun onCreate(savedInstanceState: Bundle?) {
            binding = ActivityMain3Binding.inflate(layoutInflater)
            sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]

            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(binding.root)

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
            supportActionBar?.elevation = 0f

            supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#EE6627")))

        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.menu_options, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            val username = intent.getStringExtra("USERNAME")
            val password = intent.getStringExtra("PASSWORD")
            val email = intent.getStringExtra("EMAIL")
            val number = intent.getStringExtra("NUMBER")
            val gender = intent.getStringExtra("GENDER")

            return when (item.itemId) {
                R.id.action_profile -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    Intent(this, MainActivity2::class.java).apply {
                        putExtra("USERNAME", username)
                        putExtra("PASSWORD", password)
                        putExtra("EMAIL", email)
                        putExtra("NUMBER", number)
                        putExtra("GENDER", gender)
                        startActivity(this)
                    }
                    true
                }

                R.id.action_logout -> {
                    sharedViewModel.clearData()
                    Intent(this, MainActivity::class.java).apply {
                        startActivity(this)
                    }
                    true
                }

                else -> super.onOptionsItemSelected(item)
            }
        }
    }