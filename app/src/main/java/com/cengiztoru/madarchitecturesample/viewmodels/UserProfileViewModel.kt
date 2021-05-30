package com.cengiztoru.madarchitecturesample.viewmodels

import androidx.lifecycle.*
import com.cengiztoru.madarchitecturesample.data.model.User
import com.cengiztoru.madarchitecturesample.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Cengiz TORU on 18/05/2021.
 * cengiz.toru@tsoft.com.tr
 */
@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val USER_ID = "user_id"

    val userId: String = savedStateHandle[USER_ID]
        ?: throw IllegalArgumentException("missing user id")


    val _user: MutableLiveData<User> = MutableLiveData(User())
    val user: LiveData<User>
        get() = _user

    init {
        viewModelScope.launch {
            _user.value = userRepository.getUser(userId)
        }
    }

}