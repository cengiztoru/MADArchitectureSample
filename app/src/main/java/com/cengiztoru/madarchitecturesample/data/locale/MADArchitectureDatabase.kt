package com.cengiztoru.madarchitecturesample.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cengiztoru.madarchitecturesample.data.locale.entity.SearchUser


/**
 * Created by Cengiz TORU on 27/07/2021.
 * cengiztoru@gmail.com
 */

@Database(entities = [SearchUser::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MADArchitectureDatabase : RoomDatabase() {
    abstract fun userSearchDao(): SearchUserDao
}