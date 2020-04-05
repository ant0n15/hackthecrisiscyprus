package com.delivery.bakery.injection.binding

import com.delivery.bakery.injection.module.TaskModule
import com.delivery.bakery.injection.scopes.PerActivity
import com.delivery.bakery.injection.scopes.PerFragment
import com.delivery.bakery.ui.home.HomeActivity
import com.delivery.bakery.ui.home.HomeFragment
import com.delivery.bakery.ui.product.ProductActivity
import com.delivery.bakery.ui.product.ui.product.ProductFragment
import com.delivery.bakery.ui.register.RegisterActivity
import com.delivery.bakery.ui.register.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TaskBindings {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindRegisterActivity(): RegisterActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindRegisterFragment(): RegisterFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindProductActivity(): ProductActivity

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindProductFragment(): ProductFragment
}
