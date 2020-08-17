package com.npb.noplanbnotes.ui.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.npb.noplanbnotes.db.model.Note
import com.npb.noplanbnotes.db.repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel (private val notesRepository: NotesRepository) : ViewModel(), Observable {
//    private var notesRepository = NotesRepository()
//    var notes = liveData(Dispatchers.IO) {
//        val result= notesRepository.getNotes()
//        emit(result)
//
//    }

    @Bindable
    val notesText = MutableLiveData<String>()

    @Bindable
    val addOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val deleteOrClearAllButtonText = MutableLiveData<String>()

    init {
        addOrUpdateButtonText.value = "Add"
        deleteOrClearAllButtonText.value = "Clear All"
    }

    fun getAllNotes() = notesRepository.getAllNotes()

    fun addOrUpdate() {
        viewModelScope.launch{
            val notes = notesText.value!!
            notesRepository.insertNote(Note(0,notes))
            notesText.value = null
        }
    }
    fun insertNote(note: Note) =
        viewModelScope.launch{
            notesRepository.insertNote(note)
        }

    fun deleteAllNotes() =  viewModelScope.launch{
        notesRepository.deleteAllNotes()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }




}