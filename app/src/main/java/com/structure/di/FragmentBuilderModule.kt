package com.structure.di

import com.structure.AuthActivity
import com.structure.di.auth.AuthModule
import com.structure.di.auth.AuthViewModelModule
import com.structure.di.teest.TestViewModelModule
import com.structure.ui.auth.TestFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [TestViewModelModule::class])
    abstract fun contributeTestFragment() : TestFragment
}