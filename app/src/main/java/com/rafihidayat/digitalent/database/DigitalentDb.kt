package com.rafihidayat.digitalent.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rafihidayat.digitalent.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DigitalentDb : RoomDatabase() {
    abstract val dao: UserDao

    companion object {
        @Volatile
        private var INSTANCE: DigitalentDb? = null

        fun getInstance(context: Context): DigitalentDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DigitalentDb::class.java,
                        "digitalent.db"
                    ).build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}