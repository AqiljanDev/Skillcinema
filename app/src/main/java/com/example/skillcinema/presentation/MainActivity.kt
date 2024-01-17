package com.example.skillcinema.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.skillcinema.R
import com.example.skillcinema.presentation.onBoarding.NavigationFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    NavigationFragment()
                ).commit()
        }
    }
}