package com.beardness.taggallery.navigation.folders

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beardness.taggallery.presentation.screens.folders.FoldersScreen
import com.beardness.taggallery.presentation.screens.gallery.GalleryScreen
import com.beardness.taggallery.presentation.screens.photo.PhotoScreen

@Composable
fun FoldersNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "folders") {
        composable(route = "folders") {
            FoldersScreen()
        }

        composable(route = "folder/{folderId}") {
            GalleryScreen()
        }

        composable(route = "photo/{photoId}") {
            PhotoScreen()
        }
    }
}