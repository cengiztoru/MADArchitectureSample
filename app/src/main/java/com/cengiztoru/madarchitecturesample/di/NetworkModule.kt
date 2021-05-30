package com.cengiztoru.madarchitecturesample.di

import com.cengiztoru.madarchitecturesample.BuildConfig
import com.cengiztoru.madarchitecturesample.data.remote.Webservices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Cengiz TORU on 30/05/2021.
 * cengiz.toru@tsoft.com.tr
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor? {
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return loggingInterceptor
        }
        return null
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor?
    ): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        loggingInterceptor?.let {
            okHttpBuilder.addInterceptor(it)
        }
        return okHttpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory() = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideWebServices(retrofit: Retrofit): Webservices {
        return retrofit.create(Webservices::class.java)
    }


}