package com.cengiztoru.madarchitecturesample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cengiztoru.madarchitecturesample.databinding.ActivityMainBinding
import com.cengiztoru.madarchitecturesample.ui.fragments.user_profile.UserProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userId = "cengiztoru"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(
                binding.frmFragmentContainer.id,
                UserProfileFragment.newInstance(userId),
            )
            .addToBackStack(null)
            .commit()
    }
}