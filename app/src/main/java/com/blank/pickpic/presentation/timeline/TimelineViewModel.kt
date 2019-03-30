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

    val input: TimelineViewModelInput = object : TimelineViewModelInput {
        override fun loadPhotos() {
            getPhotos(Unit) { it.either(::handleFailure, ::handlePhotos) }
        }
    }

    val output: TimelineViewModelOutput = object : TimelineViewModelOutput {
        override fun photos(): LiveData<List<Photo>> = _photoListResult
    }

    init {
        input.loadPhotos()
    }

    fun handlePhotos(photos: List<Photo>) {
        _photoListResult.postValue(photos)
    }

    fun handleFailure(failure: Failure) {
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
}