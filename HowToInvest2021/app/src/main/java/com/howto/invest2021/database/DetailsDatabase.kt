package com.howto.invest2021.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.howto.invest2021.model.DetailsModel

@Database(entities = [DetailsModel::class], version = 1, exportSchema = false)
abstract class DetailsDatabase: RoomDatabase() {

    abstract val detailsDao: DetailsDatabaseDao

    companion object {
        @Volatile
        private var DATABASE_INSTANCE: DetailsDatabase? = null

        fun getDatabaseInstance(context: Context): DetailsDatabase {
            synchronized(this) {
                var databaseInstance = DATABASE_INSTANCE

                if (databaseInstance==null) {
                    databaseInstance = Room.databaseBuilder(
                        context.applicationContext,
                        DetailsDatabase::class.java,
                        "details_database")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return databaseInstance
            }
        }
    }
}