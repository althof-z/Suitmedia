package com.test.suitmedia.ui

import android.content.Context
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.test.suitmedia.data.model.User
import com.test.suitmedia.data.repository.ReqresRepositoryImpl
import com.test.suitmedia.data.source.UserRemoteDataImpl
import com.test.suitmedia.data.source.provideReqresService
import com.test.suitmedia.domain.ReqresRepository
import kotlinx.coroutines.launch

class ThirdActivityViewModel(
    private val reqresRepository: ReqresRepository
) : ViewModel() {

    companion object {
        fun provideFactory(
            owner: SavedStateRegistryOwner,
            context: Context
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory(owner, null) {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle
                ): T {
                    val remoteData = UserRemoteDataImpl(provideReqresService(context))
                    val repository = ReqresRepositoryImpl(remoteData)
                    return ThirdActivityViewModel(repository) as T
                }
            }
    }

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> get() = _error

    fun retrieveUsers() {
        viewModelScope.launch {
            try {
                _loading.value = true
                _users.value = reqresRepository.fetchData()
                _loading.value = false
            } catch (exception: Exception) {
                _error.value = exception
            }
        }
    }
}
