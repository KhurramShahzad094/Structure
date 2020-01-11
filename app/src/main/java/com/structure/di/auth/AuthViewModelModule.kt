package com.structure.di.auth

import androidx.lifecycle.ViewModel
import com.structure.di.viewmodel.ViewModelKey
import com.structure.ui.auth.AuthViewModel
import com.structure.ui.auth.SharedViewModel
import com.structure.ui.auth.TestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel::class)
    abstract fun bindTestViewModel(viewModel: TestViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel::class)
    abstract fun bindSharedViewModel(viewModel: SharedViewModel) : ViewModel
}