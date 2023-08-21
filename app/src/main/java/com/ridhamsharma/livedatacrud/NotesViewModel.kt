package com.ridhamsharma.livedatacrud

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {

    var notesEntity: LiveData<List<NotesEntity>>
    var notesDaoInterface: NotesDaoInterface

    init {
        notesDaoInterface= NotesDb.getDatabase(application).notesDaoInterface()
        notesEntity = notesDaoInterface.getPersonDetails()

    }

    fun addNotes(notesEntity: NotesEntity){
        viewModelScope.launch {
            notesDaoInterface.addNotes(notesEntity)
        }

    }
    fun Delete(notesEntity: NotesEntity){
        viewModelScope.launch{
            notesDaoInterface.Delete(notesEntity)
        }
    }

}