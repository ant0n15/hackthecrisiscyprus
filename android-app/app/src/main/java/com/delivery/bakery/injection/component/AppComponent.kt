package com.delivery.bakery.injection.component

import com.delivery.bakery.injection.App
import com.delivery.bakery.injection.binding.TaskBindings
import com.delivery.bakery.injection.module.AppModule
import com.delivery.bakery.injection.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        TaskBindings::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance app: App): AppComponent
    }
}