package com.example.skillcinema.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import com.example.skillcinema.R
import com.example.skillcinema.databinding.ActivityMainBinding
import com.example.skillcinema.presentation.onBoarding.NavigationFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.action_homepage -> {
                    navController.navigate(R.id.homepageFragment)
                    return@setOnItemSelectedListener true
                }

                else -> false
            }
        }
    }
}