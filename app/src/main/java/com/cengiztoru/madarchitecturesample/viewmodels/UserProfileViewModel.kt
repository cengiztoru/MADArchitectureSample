package com.cengiztoru.madarchitecturesample.viewmodels

import androidx.lifecycle.*
import com.cengiztoru.madarchitecturesample.data.model.User
import com.cengiztoru.madarchitecturesample.repository.SearchUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Cengiz TORU on 18/05/2021.
 * cengiz.toru@tsoft.com.tr
 */
@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val searchUserRepository: SearchUserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val SEARCH_QUERY = "search_query"

    val searchQuery: String = savedStateHandle[SEARCH_QUERY]
        ?: throw IllegalArgumentException("missing user id")

    private val _user: MutableLiveData<User> = MutableLiveData(User())
    val user: LiveData<User>
        get() = _user

    init {
        viewModelScope.launch {
            searchUserRepository.searchUser(searchQuery).collect {
                _user.value = it.user
            }
        }
    }

}