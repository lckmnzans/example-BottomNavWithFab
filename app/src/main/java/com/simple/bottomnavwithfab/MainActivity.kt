package com.simple.bottomnavwithfab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_view, PageFragment())
            .commit()

        bottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavigationView.apply {
            background = null
            menu.getItem(2).isEnabled = false
        }
    }
}