package com.structure.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.structure.di.viewmodel.ViewModelProvidersFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProvidersFactory: ViewModelProvidersFactory) : ViewModelProvider.Factory
}