package com.example.second_home_task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.second_home_task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_place_holder, ListBlankFragment.newInstance())
                .commit()
        }
    }
}

