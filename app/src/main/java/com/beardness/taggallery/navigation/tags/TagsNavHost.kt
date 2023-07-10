package com.beardness.taggallery.navigation.tags

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beardness.taggallery.presentation.screens.gallery.GalleryScreen
import com.beardness.taggallery.presentation.screens.photo.PhotoScreen
import com.beardness.taggallery.presentation.screens.tags.TagsScreen

@Composable
fun TagsNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "tags") {
        composable(route = "tags") {
            TagsScreen()
        }

        composable(route = "tag/{id}") {
            GalleryScreen()
        }

        composable(route = "photo/{id}") {
            PhotoScreen()
        }
    }
}