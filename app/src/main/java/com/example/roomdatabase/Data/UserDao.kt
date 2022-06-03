package com.example.roomdatabase.Data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabase.model.User

/**
 * Created by Banku
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAll(): LiveData<List<User>>


    @Update
    fun updateUser(user:User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    fun deleteAllUsers()

}