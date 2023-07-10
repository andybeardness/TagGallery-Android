package com.beardness.taggallery.activity.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.beardness.taggallery.navigation.root.RootNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val bottomNavigation = listOf(
        BottomNavItem(name = "Tags", route = "tags"),
        BottomNavItem(name = "Folders", route = "folders"),
        BottomNavItem(name = "About", route = "about"),
    )

    val navController = rememberNavController()

    val backStackEntry = navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            NavigationBar {
                bottomNavigation.forEach { navItem ->
                    val selected = navItem.route == backStackEntry.value?.destination?.route

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(route = navItem.route) {
                                popUpTo(id = navController.graph.startDestinationId) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(text = navItem.name) },
                        icon = { },
                    )
                }
            }
        }
    ) { paddings ->
        RootNavHost(
            navController = navController,
            paddings = paddings,
        )
    }
}