package com.beardness.taggallery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.beardness.taggallery.data.entity.Tag
import kotlinx.coroutines.flow.Flow

@Dao
interface TagDao {

    @Query(value = "SELECT * FROM tags")
    fun flow(): Flow<List<Tag>>
}