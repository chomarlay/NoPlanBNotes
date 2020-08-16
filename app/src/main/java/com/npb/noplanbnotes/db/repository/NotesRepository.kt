package com.npb.noplanbnotes.db.repository

import com.npb.noplanbnotes.db.dao.NoteDao
import com.npb.noplanbnotes.db.database.NoteDatabase
import com.npb.noplanbnotes.db.model.Note


class NotesRepository (private val db: NoteDatabase) {
    val noteDao = db.noteDAO

    fun getAllNotes() = noteDao.getAllNotes()

    suspend fun insertNote(note: Note) = noteDao.insertNote(note)

    suspend fun deleteAllNotes() = noteDao.deleteAll()
}
