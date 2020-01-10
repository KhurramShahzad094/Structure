package com.structure.di

import android.app.Application
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.structure.network.NetworkAPI
import com.structure.util.Constants
import com.structure.util.PreferenceManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
public class AppModule {

    @Singleton
    @Provides
    fun getApp(application: Application) : Boolean{
        return application==null
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance() : NetworkAPI{
        return Retrofit.Builder()
            .baseUrl(Constants.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideEncryptedSharedPreference(application: Application) : SharedPreferences{
        return EncryptedSharedPreferences
            .create(
                Constants.sharedPreferenceFileName,
                MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
                application.applicationContext,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
    }

    @Provides
    @Singleton
    fun providePreference(sharedPreference: SharedPreferences) : PreferenceManager{
        return PreferenceManager(sharedPreference)
    }

}