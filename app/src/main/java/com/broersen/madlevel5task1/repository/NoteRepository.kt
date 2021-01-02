package com.broersen.madlevel5task1.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.broersen.madlevel5task1.dao.NoteDao
import com.broersen.madlevel5task1.database.NotepadRoomDatabase
import com.broersen.madlevel5task1.models.Note

class NoteRepository(context: Context) {
    private val noteDao: NoteDao

    init{
        noteDao = NotepadRoomDatabase.getDatabase(context)!!.noteDao()
    }

    fun getNotepad(): LiveData<Note?>{
        return noteDao.getNotepad()
    }

    suspend fun updateNotepad(note: Note){
        noteDao.updateNote(note)
    }
}