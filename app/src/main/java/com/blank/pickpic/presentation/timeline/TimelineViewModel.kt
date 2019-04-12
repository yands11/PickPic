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

    val trigger: Trigger = object : Trigger {
        override fun loadPhotos() {
            _visibleProgress.value = true
            getPhotos(Unit) { it.either(::handlePhotos, ::handleFailure) }
        }
    }

    val bundle: LiveBundle = object : LiveBundle {
        override val photos: LiveData<List<Photo>> = _photoListResult
        override val isLoading: LiveData<Boolean> = _visibleProgress
    }

    init {
        trigger.loadPhotos()
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

    interface Trigger {
        fun loadPhotos()
    }

    interface LiveBundle {
        val photos: LiveData<List<Photo>>
        val isLoading: LiveData<Boolean>
    }
}

