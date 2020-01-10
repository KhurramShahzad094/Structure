package com.structure.di.auth

import com.structure.repository.AuthRepository
import com.structure.network.NetworkAPI
import dagger.Module
import dagger.Provides

@Module
class AuthModule {

//    @Provides
//    fun provideAuthAPI(retrofit: Retrofit) : NetworkAPI{
//        return retrofit.create(NetworkAPI::class.java)
//    }

    @Provides
    fun provideAuthRepository(networkAPI: NetworkAPI) : AuthRepository {
        return AuthRepository(networkAPI)
    }
}