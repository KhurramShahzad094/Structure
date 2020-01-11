package com.structure

import android.app.Application
import com.structure.di.AppInjector
import com.structure.di.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


public class BaseApplication : Application(), HasAndroidInjector {

    @Inject
   public lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}