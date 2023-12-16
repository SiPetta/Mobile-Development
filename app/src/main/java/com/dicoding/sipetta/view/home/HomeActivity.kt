package com.dicoding.sipetta.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dicoding.sipetta.R
import androidx.fragment.app.Fragment
import com.dicoding.sipetta.view.fragment.FavoriteFragment
import com.dicoding.sipetta.view.fragment.HomeFragment
import com.dicoding.sipetta.view.fragment.ProfileFragment
import com.dicoding.sipetta.view.post.AddNewPostActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replaceFragment(HomeFragment())
                fabAdd.visibility = View.VISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                replaceFragment(FavoriteFragment())
                fabAdd.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                replaceFragment(ProfileFragment())
                fabAdd.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private lateinit var fabAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        fabAdd = findViewById(R.id.fabAdd)
        fabAdd.setOnClickListener {
            startActivity(Intent(this@HomeActivity, AddNewPostActivity::class.java))
        }

        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
