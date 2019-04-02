package com.blank.pickpic.presentation.timeline

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blank.pickpic.data.Photo
import com.blank.pickpic.exception.Failure
import com.blank.pickpic.usecases.GetPhotos
import timber.log.Timber

class TimelineViewModel(
    private val getPhotos: GetPhotos
) : ViewModel() {

    private val _photoListResult = MutableLiveData<List<Photo>>()
    private val _visibleProgress = MutableLiveData<Boolean>()

    val input: TimelineViewModelInput = object : TimelineViewModelInput {
        override fun loadPhotos() {
            _visibleProgress.value = true
            getPhotos(Unit) { it.either(::handlePhotos, ::handleFailure) }
        }
    }

    val output: TimelineViewModelOutput = object : TimelineViewModelOutput {
        override fun photos(): LiveData<List<Photo>> = _photoListResult
        override fun isLoading(): LiveData<Boolean> = _visibleProgress
    }

    init {
        input.loadPhotos()
    }

    fun handlePhotos(photos: List<Photo>) {
        _visibleProgress.postValue(false)
        _photoListResult.postValue(photos)
    }

    fun handleFailure(failure: Failure) {
        _visibleProgress.postValue(false)
        Timber.e(
            when (failure) {
                Failure.ServerError -> "ServerError"
                Failure.NetworkConnection -> "NetworkConnectionError"
                else -> "None"
            }
        )
    }
}

interface TimelineViewModelInput {
    fun loadPhotos()
}

interface TimelineViewModelOutput {
    fun photos(): LiveData<List<Photo>>
    fun isLoading(): LiveData<Boolean>
}