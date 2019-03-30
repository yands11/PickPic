package com.blank.pickpic.ui.timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.blank.pickpic.base.BaseKodeinFragment
import com.blank.pickpic.databinding.FragmentTimelineBinding
import com.blank.pickpic.ext.viewModelProvider
import com.blank.pickpic.presentation.timeline.TimelineViewModel
import com.blank.pickpic.presentation.timeline.TimelineViewModelProviderFactory
import org.kodein.di.generic.instance


class TimelineFragment : BaseKodeinFragment() {

    private val vmProviderFactory by instance<TimelineViewModelProviderFactory>()

    private lateinit var binding: FragmentTimelineBinding
    private lateinit var viewModel: TimelineViewModel
    private lateinit var adapter: TimelineAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        FragmentTimelineBinding.inflate(inflater, container, false).also {
            binding = it
        }.apply {
            lifecycleOwner = this@TimelineFragment
            vm = viewModelProvider<TimelineViewModel>(vmProviderFactory).also {
                this@TimelineFragment.viewModel = it
            }
        }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView(binding.rcv)
        subscribe(viewModel)
    }

    private fun setUpRecyclerView(rcv: RecyclerView) {
        rcv.adapter = TimelineAdapter(this@TimelineFragment).also {
            this@TimelineFragment.adapter = it
        }
    }

    private fun subscribe(viewModel: TimelineViewModel) {
        with(viewModel.output) {
            photos().observe(this@TimelineFragment, Observer {
                this@TimelineFragment.adapter.handlePhotos(it)
            })
        }
    }

    companion object {
        fun newInstance() = TimelineFragment()
    }
}