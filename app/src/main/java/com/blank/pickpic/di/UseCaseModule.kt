package com.blank.pickpic.di

import com.blank.pickpic.repository.PhotoRepository
import com.blank.pickpic.usecases.GetPhotos
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton


val useCaseModule = Kodein.Module("use_case_module") {
    bind<GetPhotos>() with singleton {
        GetPhotos(instance<PhotoRepository>())
    }
}
