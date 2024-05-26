package com.main.phc

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.main.phc.draweritems.AppDrawer
import com.main.phc.inside.AllDestinations
import com.main.phc.inside.AppNavigationActions
import com.main.phc.inside.MainPage
import com.main.phc.inside.Product
import com.main.phc.inside.Vitamins
import com.main.phc.viewmodels.MemberViewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AppNavigation{
    companion object{

        @SuppressLint("StaticFieldLeak")
        @JvmStatic lateinit var navController: NavHostController
    }

    @Composable
    fun getNavHostController(): NavHostController {
        navController = rememberNavController()
        return navController
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {
    val memberViewModel: MemberViewModel = viewModel()
    val appNavigation = AppNavigation()
    val navController: NavHostController = appNavigation.getNavHostController()
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: AllDestinations.HOME
    val navigationActions = remember(navController) {
        AppNavigationActions(navController)
    }

    ModalNavigationDrawer(
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
        AppDrawer(
            route = currentRoute,
            navigateToHome = { navigationActions.navigateToHome() },
            navigateToVitamins = { navigationActions.navigateToVitamins() },
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            modifier = Modifier
        )
        },
        drawerState = drawerState
    ) {
        NavHost(
            navController = navController, startDestination = AllDestinations.HOME, modifier = modifier.padding()
        ) {

            composable(AllDestinations.HOME) {
                MainPage(drawerState = drawerState, memberViewModel = memberViewModel, navController = navController)
            }

            composable(AllDestinations.VITAMINS) {
                Vitamins(drawerState = drawerState, navController = navController, memberViewModel = memberViewModel)
            }

            composable(AllDestinations.PRODUCT) {
                val member = memberViewModel.member
                member?.let {
                    Product(
                        drawerState = drawerState,
                        member = member
                    )
                }
            }
        }
    }
}