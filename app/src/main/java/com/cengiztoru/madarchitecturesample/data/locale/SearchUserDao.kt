package com.cengiztoru.madarchitecturesample.data.locale

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.cengiztoru.madarchitecturesample.data.locale.entity.SearchUser
import kotlinx.coroutines.flow.Flow


/**
 * Created by Cengiz TORU on 27/07/2021.
 * cengiz.toru@gmail.com
 */

@Dao
interface SearchUserDao {
    @Insert(onConflict = REPLACE)
    suspend fun saveUserSearch(user: SearchUser)

    @Query("SELECT * FROM SearchUser WHERE searchUserQuery = :userQuery")
    fun getUser(userQuery: String): Flow<SearchUser>

    @Query("SELECT * FROM SearchUser WHERE searchUserQuery = :userQuery")
    suspend fun getUserOneShot(userQuery: String): SearchUser?

}