    package com.example.tugaspertemuan9

    import android.content.Intent
    import android.graphics.Color
    import android.graphics.drawable.ColorDrawable
    import android.os.Bundle
    import android.view.Menu
    import android.view.MenuItem
    import android.widget.Toast
    import androidx.activity.enableEdgeToEdge
    import androidx.annotation.StringRes
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import androidx.lifecycle.ViewModelProvider
    import com.example.tugaspertemuan9.databinding.ActivityMainBinding
    import com.google.android.material.tabs.TabLayoutMediator

    class MainActivity : AppCompatActivity() {

        companion object {
            @StringRes
            private val TAB_TITLES = intArrayOf(
                R.string.tab_text_1,
                R.string.tab_text_2
            )
        }

        lateinit var binding: ActivityMainBinding
        private lateinit var sharedViewModel: SharedViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            binding = ActivityMainBinding.inflate(layoutInflater)
            sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(binding.root)

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            val sectionPagerAdapter = SectionsPagerAdapter(this)
            binding.viewPager.adapter = sectionPagerAdapter

            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
            supportActionBar?.elevation = 0f

            supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#EE6627")))

        }
    }