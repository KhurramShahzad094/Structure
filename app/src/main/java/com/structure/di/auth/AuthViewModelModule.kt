package com.structure.di.auth

import androidx.lifecycle.ViewModel
import com.structure.di.viewmodel.ViewModelKey
import com.structure.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel) : ViewModel
}