package com.example.mytestkmm.data

import com.example.mytestkmm.DatabaseDriverFactory
import com.example.mytestkmm.cache.MyAppDb

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = MyAppDb(databaseDriverFactory.createDriver())
   // private val dbQuery = database.appDatabaseQueries
}