package com.delivery.bakery.injection

import com.delivery.bakery.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import kotlinx.coroutines.Dispatchers

open class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()

        // Slow init of this causes a disk read violation
        // Temporary workaround until I can look into it some more
        // See https://github.com/Kotlin/kotlinx.coroutines/issues/878
        Dispatchers.Main
    }

}