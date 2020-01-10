package com.structure.di

import com.structure.AuthActivity
import com.structure.di.auth.AuthModule
import com.structure.di.auth.AuthViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = arrayOf(AuthViewModelModule::class, AuthModule::class,FragmentBuilderModule::class)
    )
    abstract fun contributeAuthActivity() : AuthActivity
}