package com.beardness.taggallery.domain.core

import android.content.Context
import android.provider.MediaStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ImageLoaderCore @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    private val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

    private val projection = arrayOf(
        MediaStore.Images.Media.DATA,
    )

    suspend fun load(): List<String> {
        val cursor = context.contentResolver.query(
            uri,
            projection,
            null,
            null,
            null,
        )

        val paths = mutableListOf<String>()

        cursor?.use { crs ->
            val pathColumn = crs.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)

            while (crs.moveToNext()) {
                val path = crs.getString(pathColumn)

                paths.add(element = path)
            }
        }

        return paths
    }
}