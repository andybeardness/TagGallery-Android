package com.beardness.taggallery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.beardness.taggallery.data.entity.PhotoTag
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoTagDao {

    @Query(value = "SELECT * FROM photo_tags")
    fun flow(): Flow<List<PhotoTag>>
}