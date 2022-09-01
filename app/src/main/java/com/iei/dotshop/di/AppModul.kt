package com.example.developnetworktask.data.di


import android.content.Context
import com.google.gson.Gson
import com.iei.dotshop.data.remote.ApiInterface
import com.iei.dotshop.data.repository.Repository
import com.iei.dotshop.domain.LoginUseCase
import com.techlife.winwin.core.util.SessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModul {

    @Singleton
    @Provides
    fun provideSessionManager(
        @ApplicationContext context: Context,
        gson: Gson
    ) = SessionManager(context, gson)


/*

    @Singleton
    @Provides
    fun provideRepository(
        api: ApiInterface
    ): Repository = Repository(api)

    @Singleton
    @Provides
    fun provideLoginUseCase(
        repo: Repository
    ): LoginUseCase = LoginUseCase(repo)*/


}