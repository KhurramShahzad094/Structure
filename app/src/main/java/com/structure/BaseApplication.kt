package com.structure

import com.structure.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

public class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
     }
}