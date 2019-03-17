package com.blank.pickpic.presentation.newup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class NewUpViewModelProviderFactory : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(NewUpViewModel::class.java) -> NewUpViewModel() as T
        else -> super.create(modelClass)
    }
}