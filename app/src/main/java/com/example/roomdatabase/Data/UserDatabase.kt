package com.example.roomdatabase.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomdatabase.model.User
import com.example.roomdatabase.repository.UserRepository

/**
 * Created by Banku
 */
@Database(entities = [User::class], version = 2)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null;

        fun getDatabase(context: Context): UserDatabase? {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance;
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java, "user_database"
                ).addMigrations(UserRepository.migration1_2).build()
                INSTANCE = instance;
            }
            return INSTANCE;
        }
    }
}