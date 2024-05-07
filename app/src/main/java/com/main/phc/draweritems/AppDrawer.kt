package com.main.phc.draweritems

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.phc.R
import com.main.phc.inside.AllDestinations

@SuppressLint("PrivateResource")
@Composable
fun AppDrawer(
    route: String,
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToVitamins: () -> Unit,
    closeDrawer: () -> Unit,
) {
    ModalDrawerSheet(
    modifier = Modifier
    .border(
    width = 1.dp,
    color = Color.Black,
    shape = MaterialTheme.shapes.large
    ),
    drawerContainerColor = Color.White
    ) {
        DrawerHeader(
            modifier,
            route,
            navigateToHome,
            closeDrawer
        )

        NavigationDrawerItem(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color.Black
                ),
            colors = NavigationDrawerItemDefaults.colors(
                selectedContainerColor = Color.White,
                unselectedContainerColor = Color.White
            ),
            label = {
                Text(
                    text = "Vitamins",
                    color = Color.Black)
            },
            selected = route == AllDestinations.VITAMINS,
            onClick = {
                navigateToVitamins()
                closeDrawer()
            },
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.vitamins),
                    contentDescription = "Vitamins"
                )
            }
        )
    }
}
@Composable
fun DrawerHeader(
    modifier: Modifier,
    route: String,
    navigateToHome: () -> Unit,
    closeDrawer: () -> Unit,
) {
    NavigationDrawerItem(
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
            .border(
                width = 1.dp,
                color = Color.Black
            ),
        selected = route == AllDestinations.HOME,
        onClick = {
            navigateToHome()
            closeDrawer()
        },
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = Color.White,
            unselectedContainerColor = Color.White
        ),
        label = {
            IconButton(
                modifier = Modifier.fillMaxSize(),
                onClick = {
                    navigateToHome()
                    closeDrawer()
                }) {
                Image(painter = painterResource(
                    id = R.drawable.homenavlogo),
                    contentDescription = "Home")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppDrawerPreview() {
    AppDrawer(route = AllDestinations.HOME, navigateToHome = {}, navigateToVitamins = {}, closeDrawer = {})
}