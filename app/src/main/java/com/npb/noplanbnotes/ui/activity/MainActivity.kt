package com.npb.noplanbnotes.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.npb.noplanbnotes.R
import com.npb.noplanbnotes.databinding.ActivityMainBinding
import com.npb.noplanbnotes.db.database.NoteDatabase
import com.npb.noplanbnotes.db.model.Note
import com.npb.noplanbnotes.db.repository.NotesRepository
import com.npb.noplanbnotes.ui.viewmodel.NotesViewModel
import com.npb.noplanbnotes.ui.viewmodel.NotesViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val database = NoteDatabase.getInstance(this)
        val repository = NotesRepository(database)
        val notesViewModelFactory = NotesViewModelFactory(repository)
        notesViewModel = ViewModelProvider(this, notesViewModelFactory).get(NotesViewModel::class.java)
        initRecyclerView()
        initButtons()
    }

    fun initRecyclerView () {
        binding.notesRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        displayNotesList()
    }

    fun displayNotesList() {
        notesViewModel.getAllNotes().observe(this, Observer {
            binding.notesRecyclerView.adapter = NotesRecyclerViewAdapter(it, {selectedNote-> notesItemClicked(selectedNote) })
        })
    }

    fun initButtons () {
        binding.apply {
            btnAdd.setOnClickListener {
                notesViewModel.insertNote(
                    Note(0, "EFFORT")
                )
            }
            btnDeleteAll.setOnClickListener {
                notesViewModel.deleteAllNotes()
            }
        }

    }
    fun notesItemClicked(seletedNote: Note) {
        Toast.makeText(this@MainActivity, "Edit : " + seletedNote.notesText, Toast.LENGTH_SHORT)
            .show()
    }

}