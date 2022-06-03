package com.example.roomdatabase.userViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.model.User
import com.example.roomdatabase.Data.UserDatabase
import com.example.roomdatabase.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
* Created by Banku
*/
class UserViewModel(application: Application) : AndroidViewModel(application) {
    var readAllData: LiveData<List<User>>
    private var userRepository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application)?.userDao()
        userRepository = UserRepository(userDao!!);
        readAllData = userDao.readAll();
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Current Thread",Thread.currentThread().name)
            userRepository.addUser(user)
            updateUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.updateUser(user)
        }
    }
    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(user)
        }
    }
    fun deleteAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteAllUsers()
        }
    }
}