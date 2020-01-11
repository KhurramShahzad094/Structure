package com.structure.di

import android.app.Application
import com.structure.BaseApplication
import com.structure.di.viewmodel.ViewModelProviderFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, ActivityBuilderModule::class, AppModule::class, ViewModelProviderFactoryModule::class]
)
interface AppComponent{

    fun inject(application: BaseApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}