package com.cengiztoru.madarchitecturesample.di

import com.cengiztoru.madarchitecturesample.data.locale.SearchUserDao
import com.cengiztoru.madarchitecturesample.data.remote.Webservices
import com.cengiztoru.madarchitecturesample.repository.SearchUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


/**
 * Created by Cengiz TORU on 30/05/2021.
 * cengiz.toru@tsoft.com.tr
 */

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideSearchUserRepository(
        webservices: Webservices,
        searchUserDao: SearchUserDao,
        @PersistenceModule.UserSearchFreshTimeMillis searchFreshTime: Int
    ) = SearchUserRepository(webservices, searchUserDao, searchFreshTime)

}