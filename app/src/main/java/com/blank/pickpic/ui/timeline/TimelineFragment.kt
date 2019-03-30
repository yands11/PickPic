package com.blank.pickpic.ui.timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blank.pickpic.databinding.FragmentTimelineBinding
import com.blank.pickpic.ext.viewModelProvider
import com.blank.pickpic.presentation.timeline.TimelineViewModel
import com.blank.pickpic.presentation.timeline.TimelineViewModelProviderFactory


class TimelineFragment : Fragment() {

    private lateinit var binding: FragmentTimelineBinding
    private val vmProvider = TimelineViewModelProviderFactory()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentTimelineBinding.inflate(inflater, container, false).also {
                binding = it
            }.apply {
                lifecycleOwner = this@TimelineFragment
                vm = viewModelProvider<TimelineViewModel>(vmProvider)
            }.root

}