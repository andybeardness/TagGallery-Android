package com.beardness.taggallery.domain.core

import android.content.Context
import android.net.Uri
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabel
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

class ImageLabelerCore @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val labeler = ImageLabeling.getClient(ImageLabelerOptions.DEFAULT_OPTIONS)

    suspend fun label(path: String, action: (List<String>) -> Unit) {
        val file = File(path)
        val uri = Uri.fromFile(file)
        val inputImage = InputImage.fromFilePath(context, uri)

        labeler.process(inputImage)
            .addOnSuccessListener { labels ->
                val tags = labels.tags()
                action(tags)
            }
    }

    private fun List<ImageLabel>.tags(): List<String> =
        this.map { label -> label.text }
}