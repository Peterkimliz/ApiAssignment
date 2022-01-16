package com.example.authenticatedapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authenticatedapi.models.Users
import com.example.authenticatedapi.repository.Repository
import com.example.authenticatedapi.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
       private val repository:Repository= Repository()

        private var _usersLiveData = MutableLiveData<Resource<List<Users>?>>()
        val usersLiveDatas: LiveData<Resource<List<Users>?>> get() = _usersLiveData

        init {
            fetchUsers()
        }

        fun fetchUsers() {
            _usersLiveData.postValue(Resource.Loading())
            viewModelScope.launch {
                try {
                    val client = repository.getUsers()
                    _usersLiveData.postValue(Resource.Success(client.results))
                } catch (e: Exception) {

                    _usersLiveData.postValue(Resource.Error(e.message!!, null))
                }


            }


        }
}