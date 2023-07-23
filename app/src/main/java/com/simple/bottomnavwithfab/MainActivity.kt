package com.simple.bottomnavwithfab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var bottomNavigationView: NavigationBarView
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
        }.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                setFragment("Home")
                true
            }
            R.id.Search -> {
                setFragment("Search")
                true
            }
            R.id.Profile -> {
                setFragment("Profile")
                true
            }
            R.id.Settings -> {
                setFragment("Settings")
                true
            }
            else -> false
        }
    }

    private fun setFragment(title: String) {
        val fragment = PageFragment()
        val bundle = Bundle()
        bundle.putString(PageFragment.EXTRA_TITLE, title)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_view, fragment)
            .addToBackStack(title)
            .commit()
    }
}