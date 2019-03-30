package com.blank.pickpic.di

import com.blank.pickpic.presentation.timeline.TimelineViewModelProviderFactory
import com.blank.pickpic.usecases.GetPhotos
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton


val viewModelProviderModule = Kodein.Module("vm_provider_module") {

    bind<TimelineViewModelProviderFactory>() with singleton {
        TimelineViewModelProviderFactory(instance<GetPhotos>())
    }
}