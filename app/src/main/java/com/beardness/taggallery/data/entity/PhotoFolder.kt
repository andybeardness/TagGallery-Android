package com.beardness.taggallery.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_folders")
data class PhotoFolder(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "folder")
    val folder: String,

    @ColumnInfo(name = "path")
    val photo: String
)
