package com.beardness.taggallery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.beardness.taggallery.data.entity.Folder
import kotlinx.coroutines.flow.Flow

@Dao
interface FolderDao {

    @Query(value = "SELECT * FROM folders")
    fun flow(): Flow<List<Folder>>
}