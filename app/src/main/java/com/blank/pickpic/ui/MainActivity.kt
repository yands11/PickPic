package com.blank.pickpic.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.blank.pickpic.R
import com.blank.pickpic.databinding.MainActivityBinding
import com.blank.pickpic.ui.collections.CollectionsFragment
import com.blank.pickpic.ui.featured.FeaturedFragment
import com.blank.pickpic.ui.newup.NewUpFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    private val newUpFragment by lazy { NewUpFragment() }
    private val featuredFragment by lazy { FeaturedFragment() }
    private val collectionsFragment by lazy { CollectionsFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initBottomNav(binding.bottomNav)
        replaceFragment(newUpFragment)
    }

    private fun initView() {
        DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity).also {
            this.binding = it
        }
    }

    private fun initBottomNav(bottomNav: BottomNavigationView) {
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_new -> {
                    replaceFragment(newUpFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_featured -> {
                    replaceFragment(featuredFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_collections -> {
                    replaceFragment(collectionsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }

}
