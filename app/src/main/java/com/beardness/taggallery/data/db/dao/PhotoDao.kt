package com.beardness.taggallery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.beardness.taggallery.data.entity.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Query(value = "SELECT * FROM photos")
    fun flow(): Flow<List<Photo>>
}