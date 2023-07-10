package com.beardness.taggallery.di

import android.content.Context
import androidx.room.Room
import com.beardness.taggallery.data.db.Database
import com.beardness.taggallery.data.db.dao.FolderDao
import com.beardness.taggallery.data.db.dao.PhotoDao
import com.beardness.taggallery.data.db.dao.PhotoFolderDao
import com.beardness.taggallery.data.db.dao.PhotoTagDao
import com.beardness.taggallery.data.db.dao.TagDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): Database =
        Room.databaseBuilder(
            context = context,
            klass = Database::class.java,
            name = "tag-gallery-database"
        ).build()

    @Provides
    @Singleton
    fun providePhotoDao(
        database: Database,
    ): PhotoDao =
        database.photoDao()

    @Provides
    @Singleton
    fun provideTagDao(
        database: Database,
    ): TagDao =
        database.tagDao()

    @Provides
    @Singleton
    fun provideFolderDao(
        database: Database,
    ): FolderDao =
        database.folderDao()

    @Provides
    @Singleton
    fun providePhotoTagDao(
        database: Database,
    ): PhotoTagDao =
        database.photoTagDao()

    @Provides
    @Singleton
    fun providePhotoFolderDao(
        database: Database,
    ): PhotoFolderDao =
        database.photoFolderDao()
}