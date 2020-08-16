package com.npb.noplanbnotes.ui.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.npb.noplanbnotes.databinding.NotesItemBinding
import com.npb.noplanbnotes.db.model.Note

class NotesRecyclerViewAdapter (private var notesItems:List<Note>, private val clickListener: (Note)->Unit) : RecyclerView.Adapter<NotesRecyclerViewAdapter.NotesViewHolder> (){
    // Unit is the same as void in Java

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context )
        val binding = NotesItemBinding.inflate(layoutInflater)  // NotesItemBinding derived from notes_item.xml
        return NotesViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return notesItems.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(notesItems[position], clickListener)
    }

    class NotesViewHolder (val binding: NotesItemBinding): RecyclerView.ViewHolder (binding.root) {
        fun bind(note: Note, clickListener: (Note)->Unit) {
            binding.notesItem = note
            binding.root.setOnClickListener { clickListener(note) }
        }
    }

    // without data binding
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context )
//        val listItem:View = layoutInflater.inflate(R.layout.notes_item, parent, false)
//        return NotesViewHolder(listItem)
//    }
//    class NotesViewHolder (val view: View): RecyclerView.ViewHolder (view) {
//        fun bind(notes: Notes, clickListener: (Notes)->Unit) {
//            view.tv_notes.setText(notes.notesText)
//            view.setOnClickListener { clickListener(notes) }
//        }
//    }
}