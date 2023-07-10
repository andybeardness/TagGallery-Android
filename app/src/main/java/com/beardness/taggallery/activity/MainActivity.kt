package com.beardness.taggallery.activity

import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.beardness.taggallery.compose.theme.TaGGalleryTheme
import com.beardness.taggallery.navigation.root.RootNavHost
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compose()

        // TODO REMOVE
        val images = images()
        Log.d("BUGBUGBUG", "images.size = ${images.size}")
        images.forEach { image -> Log.d("BUGBUGBUG", "image = $image") }

        val image = images.first()
        val imageUri = Uri.fromFile(File(image))
        val imageMl = InputImage.fromFilePath(this, imageUri)

        val labeler = ImageLabeling.getClient(ImageLabelerOptions.DEFAULT_OPTIONS)
        val result = labeler.process(imageMl).addOnSuccessListener { labels ->
            labels.forEach { label ->
                Log.d("BUGBUGBUG", "label = $label")
            }
        }
    }

    private fun compose() {
        setContent {
            TaGGalleryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootNavHost()
                }
            }
        }
    }

    private fun images(): List<String> {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(
            MediaStore.MediaColumns._ID,
            MediaStore.MediaColumns.DISPLAY_NAME,
            MediaStore.Images.Media.DATA,
        )

        val cursor = contentResolver.query(
            uri,
            projection,
            null,
            null,
            null,
        )

        val images = mutableListOf<String>()

        cursor?.use { crs ->
            val idColumn = crs.getColumnIndexOrThrow(MediaStore.MediaColumns._ID)
            val nameColumn = crs.getColumnIndexOrThrow(MediaStore.MediaColumns.DISPLAY_NAME)
            val dataColumn = crs.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)

            while (crs.moveToNext()) {
                val id = crs.getLong(idColumn)
                val name = crs.getString(nameColumn)
                val data = crs.getString(dataColumn)
                images.add(element = data)
            }
        }

        return  images
    }
}