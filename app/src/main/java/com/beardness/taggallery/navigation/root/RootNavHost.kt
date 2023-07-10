package com.beardness.taggallery.navigation.root

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.beardness.taggallery.navigation.folders.FoldersNavHost
import com.beardness.taggallery.navigation.tags.TagsNavHost
import com.beardness.taggallery.presentation.screens.about.AboutScreen

@Composable
fun RootNavHost(
    navController: NavHostController,
    paddings: PaddingValues,
) {

    NavHost(
        modifier = Modifier
            .padding(paddingValues = paddings),
        navController = navController,
        startDestination = "tags",
    ) {
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