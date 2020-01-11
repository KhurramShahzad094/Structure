package com.structure.di.teest

import androidx.lifecycle.ViewModel
import com.structure.di.viewmodel.ViewModelKey
import com.structure.ui.auth.AuthViewModel
import com.structure.ui.auth.TestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TestViewModelModule {


//    @Binds
//    @IntoMap
//    @ViewModelKey(TestViewModel::class)
//    abstract fun bindTestViewModel(viewModel: TestViewModel) : ViewModel
}