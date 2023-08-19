package com.ridhamsharma.livedatacrud

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {
     var notesEntity: LiveData<List<NotesEntity>>
    var notesDaoInterface: NotesDaoInterface

    init {
        notesDaoInterface= NotesDb.getDatabase(application).notesDaoInterface()
        notesEntity = notesDaoInterface.getPersonDetails()

    }

    fun insertNotesDetails(notesEntity: NotesEntity){
        viewModelScope.launch {
            notesDaoInterface.addNotes(notesEntity)
        }
    }

}