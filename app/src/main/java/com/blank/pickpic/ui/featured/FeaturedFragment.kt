package com.blank.pickpic.ui.featured

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blank.pickpic.databinding.FeaturedFragmentBinding

class FeaturedFragment : Fragment() {

    private lateinit var binding: FeaturedFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        FeaturedFragmentBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

}