package com.hung.todotask

import androidx.room.Database
import androidx.room.RoomDatabase

//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//@Database(entities = [Task::class], version = 1)
//abstract class TaskRoomDatabase : RoomDatabase() {
////
////    abstract fun taskDao(): TaskDao
////
////    companion object {
////        @Volatile
////        private var INSTANCE: TaskRoomDatabase? = null
////
////        fun getDatabase(
////            context: Context,
////            scope: CoroutineScope
////        ): TaskRoomDatabase {
////            return INSTANCE ?: synchronized(this) {
////                val instance = Room.databaseBuilder(
////                    context.applicationContext,
////                    TaskRoomDatabase::class.java,
////                    "task_database"
////                )
////                    .fallbackToDestructiveMigration()
////                    .addCallback(TaskDatabaseCallback(scope))
////                    .build()
////                INSTANCE = instance
////                // return instance
////                instance
////            }
////        }
////
////        private class TaskDatabaseCallback(
////            private val scope: CoroutineScope
////        ) : RoomDatabase.Callback() {
////
////            override fun onCreate(db: SupportSQLiteDatabase) {
////                super.onCreate(db)
////                INSTANCE?.let { database ->
////                    scope.launch(Dispatchers.IO) {
////                        populateDatabase(database.taskDao())
////                    }
////                }
////            }
////        }
////        suspend fun populateDatabase(taskDao: TaskDao) {
////            taskDao.deleteAll()
////
////            var task = Task("Hello")
////            taskDao.insert(task)
////            task = Task("World!")
////            taskDao.insert(task)
////        }
////    }
//}




@Database(entities = arrayOf(Task::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}