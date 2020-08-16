package com.npb.noplanbnotes.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id: Int ,
    val notesText: String)