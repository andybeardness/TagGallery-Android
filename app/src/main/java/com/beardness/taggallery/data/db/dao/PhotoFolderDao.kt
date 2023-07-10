package com.beardness.taggallery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.beardness.taggallery.data.entity.PhotoFolder
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoFolderDao {

    @Query(value = "SELECT * FROM photo_folders")
    fun flow(): Flow<List<PhotoFolder>>
}