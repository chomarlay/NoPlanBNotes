package com.npb.noplanbnotes.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.npb.noplanbnotes.db.dao.NoteDao
import com.npb.noplanbnotes.db.model.Note

@Database(entities = arrayOf(Note::class), version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDAO : NoteDao

    companion object{
        @Volatile
        private var INSTANCE : NoteDatabase? = null
        fun getInstance(context: Context):NoteDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "notesdb"
                    ).build()
                }
                return instance
            }
        }

    }
}