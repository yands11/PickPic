package com.blank.pickpic

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.blank.pickpic.databinding.MainActivityBinding
import com.blank.pickpic.newup.NewUpFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initBottomNav(binding.bottomNav)
        initFragment(binding.container)
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
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_featured -> {
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_collections -> {
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    private fun initFragment(container: FrameLayout) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, NewUpFragment())
            addToBackStack(null)
            commit()
        }
    }

}
