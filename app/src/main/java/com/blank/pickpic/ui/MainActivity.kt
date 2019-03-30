package com.blank.pickpic.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.blank.pickpic.R
import com.blank.pickpic.databinding.MainActivityBinding
import com.blank.pickpic.ui.timeline.TimelineFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    private val timelineFragment by lazy { TimelineFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<MainActivityBinding>(
                this@MainActivity,
                R.layout.main_activity
        ).also {
            this.binding = it
        }

        replaceFragment(timelineFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }

}
