package com.cengiztoru.madarchitecturesample.data.locale

import androidx.room.TypeConverter
import com.cengiztoru.madarchitecturesample.data.locale.entity.SearchUser
import com.google.gson.Gson


class Converters {

    @TypeConverter
    fun fromUserSearch(searchUser: SearchUser?): String = Gson().toJson(searchUser)

    @TypeConverter
    fun toUserSearch(value: String): SearchUser =
        Gson().fromJson(value, SearchUser::class.java)

}