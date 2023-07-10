package com.beardness.taggallery.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_tags")
data class PhotoTag(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "tag")
    val tag: String,

    @ColumnInfo(name = "photo")
    val photo: String
)
