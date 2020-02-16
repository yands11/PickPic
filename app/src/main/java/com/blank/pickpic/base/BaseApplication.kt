package com.blank.pickpic.base

import android.app.Application
import com.blank.pickpic.di.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import timber.log.Timber


class BaseApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@BaseApplication))
        import(commonModule)
        import(networkModule)
        import(apiModule)
        import(repositoryModule)
        import(useCaseModule)
        import(viewModelProviderModule)
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        // TODO : set config
//        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
//        else Timber.plant(NotLoggingTree())
    }
}