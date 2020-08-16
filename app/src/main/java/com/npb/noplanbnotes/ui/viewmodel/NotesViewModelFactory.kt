package com.npb.noplanbnotes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.npb.noplanbnotes.db.repository.NotesRepository

class NotesViewModelFactory(private val repository: NotesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NotesViewModel::class.java)){
            return NotesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}