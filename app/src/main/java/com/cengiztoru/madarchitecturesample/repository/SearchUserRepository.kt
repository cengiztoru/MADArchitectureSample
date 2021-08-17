package com.cengiztoru.madarchitecturesample.repository

import android.util.Log
import com.cengiztoru.madarchitecturesample.data.locale.SearchUserDao
import com.cengiztoru.madarchitecturesample.data.locale.entity.SearchUser
import com.cengiztoru.madarchitecturesample.data.locale.entity.isFresh
import com.cengiztoru.madarchitecturesample.data.remote.Webservices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Cengiz TORU on 30/05/2021.
 * cengiz.toru@tsoft.com.tr
 */

//class UserRepository @Inject constructor(private val webservices: Webservices) {    // you don't need RepositoryModule when use like this
class SearchUserRepository(
    private val webservices: Webservices,
    private val searchUserDao: SearchUserDao,
    private val searchFreshTime: Int
) {

    private val TAG = "SearchUserRepository"

    suspend fun searchUser(searchQuery: String): Flow<SearchUser> =
        isUserSearchAvailable(searchQuery, searchFreshTime) ?: run {
            Log.d(TAG, "user is NOT fresh SO FETCH USER FROM REMOTE")
            val user = webservices.searchUser(searchQuery)
            val searchUser = SearchUser(searchQuery, user, System.currentTimeMillis())
            searchUserDao.saveUserSearch(searchUser)
            flow { emit(searchUser) }
        }


    private suspend fun isUserSearchAvailable(
        searchQuery: String,
        searchFreshTime: Int
    ): Flow<SearchUser>? {
        searchUserDao.getUserOneShot(searchQuery)?.let { user ->
            if (user.isFresh(searchFreshTime)) {
                Log.d(TAG, "user is fresh")
                return flow { emit(user) }
            }
        }
        return null
    }

}