package com.npb.noplanbnotes.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.npb.noplanbnotes.db.model.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note):Long

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM NOTE")
    suspend fun deleteAll()

    @Query("SELECT * FROM NOTE")
    fun getAllNotes() : LiveData<List<Note>>
}