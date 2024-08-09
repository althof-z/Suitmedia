package com.test.suitmedia.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.savedstate.SavedStateRegistryOwner
import com.test.suitmedia.data.model.User
import com.test.suitmedia.data.repository.ReqresRepositoryImpl
import com.test.suitmedia.data.source.UserRemoteData
import com.test.suitmedia.data.source.UserRemoteDataImpl
import com.test.suitmedia.data.source.model.Users
import com.test.suitmedia.data.source.provideReqresService
import com.test.suitmedia.domain.ReqresRepository
import kotlinx.coroutines.launch

class ThirdActivityViewModel(
    private val reqresRepository: ReqresRepository,
) : ViewModel() {

    companion object {
        fun provideFactory(
            owner: SavedStateRegistryOwner,
            context: Context,
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory(owner, null) {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle,
                ): T {
                    val remoteData: UserRemoteData = UserRemoteDataImpl(
                        reqresService = provideReqresService(context)
                    )
                    val reqresRepository: ReqresRepository = ReqresRepositoryImpl(
                        remoteDataSource = remoteData
                    )
                    return ThirdActivityViewModel(
                        reqresRepository = reqresRepository
                    ) as T
                }
            }
    }

    private val _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> = _users

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun retrieveUsers() {
        Log.d("VIEWMODEL","'ASDF")
        viewModelScope.launch {
            try {
                _users.value = reqresRepository.fetchData()
            } catch (exception: Exception) {
                Log.d("ERRONGENTOT",exception.toString())
                _error.value = exception
            }
        }
    }
}
