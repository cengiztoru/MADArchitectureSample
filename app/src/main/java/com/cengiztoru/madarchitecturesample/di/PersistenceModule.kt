package com.cengiztoru.madarchitecturesample.di

import android.content.Context
import androidx.room.Room
import com.cengiztoru.madarchitecturesample.data.locale.MADArchitectureDatabase
import com.cengiztoru.madarchitecturesample.util.oneWeekMillis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * Created by Cengiz TORU on 27/07/2021.
 * cengiz.toru@tsoft.com.tr
 */

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        MADArchitectureDatabase::class.java, "MADArchitectureSample"
    ).build()

    @Provides
    fun provideUserDao(
        db: MADArchitectureDatabase
    ) = db.userSearchDao()

    /** --------------------------------------------------------------- */
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UserSearchFreshTimeMillis

    @UserSearchFreshTimeMillis
    @Provides
    fun provideSearchFreshTimeMillis(): Int = oneWeekMillis()

    /** --------------------------------------------------------------- */


}
