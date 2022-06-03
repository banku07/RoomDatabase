package com.example.roomdatabase.repository

import androidx.lifecycle.LiveData
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomdatabase.model.User
import com.example.roomdatabase.Data.UserDao

/**
 * Created by Banku
 */
class UserRepository(private val userDao: UserDao) {

    var readAll: LiveData<List<User>> = userDao.readAll();

   suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
    fun  deleteAllUsers(){
        userDao.deleteAllUsers()
    }

    companion object{
        val migration1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user_table ADD COLUMN place INTEGER NOT NULL DEFAULT(1)")
            }

        }
    }

}