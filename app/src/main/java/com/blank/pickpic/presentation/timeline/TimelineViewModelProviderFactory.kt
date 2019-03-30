package com.blank.pickpic.presentation.timeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class TimelineViewModelProviderFactory : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(TimelineViewModel::class.java) -> TimelineViewModel() as T
        else -> super.create(modelClass)
    }
}