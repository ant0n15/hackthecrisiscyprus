package com.delivery.bakery.injection.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.delivery.bakery.injection.binding.TaskBindings
import com.delivery.bakery.injection.scopes.PerActivity
import com.delivery.bakery.injection.scopes.PerFragment
import com.delivery.bakery.ui.home.HomeFragment
import com.delivery.bakery.ui.home.HomeViewModel
import com.delivery.bakery.ui.product.ui.product.ProductFragment
import com.delivery.bakery.ui.product.ui.product.ProductViewModel
import com.delivery.bakery.ui.register.RegisterActivity
import dagger.Module
import dagger.Provides

@Module(includes = [TaskBindings::class])
class TaskModule {

    @Provides
    @PerActivity
    fun provideContext(activity: RegisterActivity): Context = activity

    @Provides
    @PerFragment
    fun provideHomeViewModel(
        fragment: HomeFragment
    ): HomeViewModel = ViewModelProvider(fragment).get(HomeViewModel::class.java)

    @Provides
    @PerFragment
    fun provideProductViewModel(
        fragment: ProductFragment
    ): ProductViewModel = ViewModelProvider(fragment).get(ProductViewModel::class.java)

}
