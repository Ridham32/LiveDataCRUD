package com.ridhamsharma.livedatacrud

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDaoInterface {
    @Insert
    suspend fun addNotes(notesEntity: NotesEntity)

    @Delete
    suspend fun Delete(notesEntity: NotesEntity)

    @Update
    suspend fun Update(notesEntity: NotesEntity)

    @Query("SELECT * from NotesEntity" )
      fun getPersonDetails():LiveData<List<NotesEntity>>
}