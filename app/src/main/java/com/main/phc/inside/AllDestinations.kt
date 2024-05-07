package com.main.phc.inside

import androidx.navigation.NavHostController
import com.main.phc.inside.AllDestinations.HOME
import com.main.phc.inside.AllDestinations.VITAMINS

object AllDestinations {
    const val HOME = "Home"
    const val VITAMINS = "Vitamins"
}

class AppNavigationActions(private val navController: NavHostController) {

    fun navigateToHome() {
        navController.navigate(HOME) {
            popUpTo(HOME)
        }
    }

    fun navigateToVitamins() {
        navController.navigate(VITAMINS) {
            launchSingleTop = true
            restoreState = true
        }
    }
}