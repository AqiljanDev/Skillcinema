package com.example.skillcinema.presentation.onBoarding

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.skillcinema.R
import com.example.skillcinema.databinding.ActivityOnBoardingBinding

private const val PREFS_DATA = "prefs_data"
private const val IS_INTRO_OPENED = "isIntroOpened"
class OnBoardingActivity : AppCompatActivity() {
    private val binding: ActivityOnBoardingBinding by lazy {
        ActivityOnBoardingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container_on_boarding) as NavHostFragment
        val navController = navHostFragment.navController

        if (restorePrefsData()) {
            navController.navigate(R.id.loadingFragment)
        }

        binding.tvSkip.setOnClickListener {
            navController.navigate(R.id.action_navigationFragment_to_loadingFragment)

            savePrefsData()
        }
    }

    private fun restorePrefsData(): Boolean {
        val pref = getSharedPreferences(PREFS_DATA, Context.MODE_PRIVATE)

        return pref.getBoolean(IS_INTRO_OPENED, false)
    }

    private fun savePrefsData() {
        val pref = getSharedPreferences(PREFS_DATA, Context.MODE_PRIVATE)
        pref.edit()
            .putBoolean(IS_INTRO_OPENED, true)
            .apply()
    }
}