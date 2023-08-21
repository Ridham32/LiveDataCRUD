package com.ridhamsharma.livedatacrud

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NotesEntity (
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @ColumnInfo
        var name: String?=null,
        @ColumnInfo
        var age:String?= null,
//        @ColumnInfo
//        var time: String?= null
    )
