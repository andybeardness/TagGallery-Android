package com.beardness.taggallery.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags")
data class Tag(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "tag")
    val tag: String,
)
