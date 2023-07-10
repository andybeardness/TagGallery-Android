package com.beardness.taggallery.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "folders")
data class Folder(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "folder")
    val folder: String,
)
