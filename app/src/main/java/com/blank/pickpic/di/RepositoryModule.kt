package com.blank.pickpic.di

import com.blank.pickpic.repository.PhotoRepository
import com.blank.pickpic.repository.PhotoRepositoryImpl
import com.blank.pickpic.services.UpsplashService
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val repositoryModule = Module("repository_module") {

    bind<PhotoRepository>() with singleton {
        PhotoRepositoryImpl(instance<UpsplashService>())
    }

}
