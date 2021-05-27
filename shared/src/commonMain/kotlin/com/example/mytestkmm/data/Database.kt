package com.example.mytestkmm.data

import com.example.mytestkmm.DatabaseDriverFactory
import com.example.mytestkmm.cache.Hello
import com.example.mytestkmm.cache.MyAppDb

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = MyAppDb(databaseDriverFactory.createDriver())
  private val dbQuery = database.myAppDbQueries



     fun insert(it: String) {
        dbQuery.insertHello(title = it
        )
    }

    fun getData():List<Hello> {
       return dbQuery.selectAll().executeAsList()
    }
}

