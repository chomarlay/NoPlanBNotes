package com.npb.noplanbnotes.ui.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.npb.noplanbnotes.db.model.Note
import com.npb.noplanbnotes.db.repository.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel (private val notesRepository: NotesRepository) : ViewModel() {
//    private var notesRepository = NotesRepository()
//    var notes = liveData(Dispatchers.IO) {
//        val result= notesRepository.getNotes()
//        emit(result)
//
//    }

    fun getAllNotes() = notesRepository.getAllNotes()

    fun insertNote(note: Note) =
        viewModelScope.launch{
            notesRepository.insertNote(note)
        }

    fun deleteAllNotes() =  viewModelScope.launch{
        notesRepository.deleteAllNotes()
    }

//    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
//
//    }
//
//    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
//
//    }


}