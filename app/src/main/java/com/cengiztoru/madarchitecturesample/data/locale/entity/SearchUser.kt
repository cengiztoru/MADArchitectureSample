package com.cengiztoru.madarchitecturesample.data.locale.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.cengiztoru.madarchitecturesample.data.locale.Converters
import com.cengiztoru.madarchitecturesample.data.model.User

@Entity
@TypeConverters(Converters::class)
data class SearchUser(
    @PrimaryKey val searchUserQuery: String = "",          //keep in mind. It shouldn't be null
    @Embedded
    val user: User?,
    val searchTime: Long
)

fun SearchUser.isFresh(searchFreshTime: Int) =
    System.currentTimeMillis() - this.searchTime < searchFreshTime

