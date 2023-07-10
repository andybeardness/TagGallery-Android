package com.beardness.taggallery.navigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beardness.taggallery.navigation.folders.FoldersNavHost
import com.beardness.taggallery.navigation.tags.TagsNavHost
import com.beardness.taggallery.presentation.screens.about.AboutScreen

@Composable
fun RootNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "tags") {
        composable(route = "tags") {
            TagsNavHost()
        }

        composable(route = "folders") {
            FoldersNavHost()
        }

        composable(route = "about") {
            AboutScreen()
        }
    }
}