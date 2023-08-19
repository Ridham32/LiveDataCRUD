package com.ridhamsharma.livedatacrud

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [NotesEntity::class])
abstract class NotesDb:RoomDatabase() {
    abstract fun notesDaoInterface(): NotesDaoInterface

    companion object{
        private var notesDb: NotesDb?= null

        fun getDatabase(context: Context): NotesDb {
            if(NotesDb ==null){
                notesDb = Room.databaseBuilder(context,NotesDb::class.java,context.resources.getString(R.string.app_name)).build()
            }
            return notesDb!!
        }



    }
}