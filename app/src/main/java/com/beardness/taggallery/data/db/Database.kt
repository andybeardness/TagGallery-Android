package com.beardness.taggallery.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beardness.taggallery.data.db.dao.FolderDao
import com.beardness.taggallery.data.db.dao.PhotoDao
import com.beardness.taggallery.data.db.dao.PhotoFolderDao
import com.beardness.taggallery.data.db.dao.PhotoTagDao
import com.beardness.taggallery.data.db.dao.TagDao
import com.beardness.taggallery.data.entity.Folder
import com.beardness.taggallery.data.entity.Photo
import com.beardness.taggallery.data.entity.PhotoFolder
import com.beardness.taggallery.data.entity.PhotoTag
import com.beardness.taggallery.data.entity.Tag

@Database(
    entities = [
        Photo::class,
        Tag::class,
        Folder::class,
        PhotoTag::class,
        PhotoFolder::class,
    ],
    version = 1,
)
abstract class Database : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
    abstract fun tagDao(): TagDao
    abstract fun folderDao(): FolderDao
    abstract fun photoTagDao(): PhotoTagDao
    abstract fun photoFolderDao(): PhotoFolderDao

}