package com.cengiztoru.madarchitecturesample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cengiztoru.madarchitecturesample.data.model.User


/**
 * Created by Cengiz TORU on 18/05/2021.
 * cengiz.toru@tsoft.com.tr
 */
class UserProfileViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val USER_ID = "user_id"

    val userId: String = savedStateHandle[USER_ID]
        ?: throw IllegalArgumentException("missing user id")

    val user: LiveData<User> = MutableLiveData(User())  //todo
}