package com.blank.pickpic.presentation.timeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blank.pickpic.usecases.GetPhotos


class TimelineViewModelProviderFactory(private val getPhotos: GetPhotos) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(TimelineViewModel::class.java) -> TimelineViewModel(getPhotos = getPhotos) as T
        else -> super.create(modelClass)
    }
}