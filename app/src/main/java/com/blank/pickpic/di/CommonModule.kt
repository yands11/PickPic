package com.blank.pickpic.di

import android.app.Application
import android.os.Bundle
import com.blank.pickpic.ext.getMetadata
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton


val commonModule = Kodein.Module("common_module") {
    bind<Bundle>("meta-data") with singleton {
        instance<Application>().applicationContext.getMetadata()
    }
}