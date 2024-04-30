package com.main.phc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.main.phc.inside.MainPage
import com.main.phc.ui.theme.PHCTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PHCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Drawer()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Drawer() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by remember { mutableIntStateOf(0) }

    val items = listOf(
        Drawers(R.drawable.baby, "For children"),
        Drawers(R.drawable.herbs, "Herbs"),
        Drawers(R.drawable.hygiene, "Hygiene"),
        Drawers(R.drawable.vitamins, "Vitamins"),
    )

    val selectedItem = remember { mutableStateOf(items[0]) }
    ModalNavigationDrawer(
//        gesturesEnabled = drawerState.isOpen,
        scrimColor = Color.Transparent,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = MaterialTheme.shapes.large
                    ),
                drawerContainerColor = Color.White
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Black
                    )
                ) {
                    IconButton(
                        modifier = Modifier.fillMaxSize(),
                        onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                    }) {
                        Image(painter = painterResource(
                            id = R.drawable.homenavlogo),
                            contentDescription = "Home")
                    }
                }
                items.forEachIndexed { index, item ->
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
                                text = item.label,
                                color = Color.Black)
                        },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Image(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.label
                            )
                        },
                    )
                }
            }
        }
    )
    {
        MainPage {}
    }
}

data class Drawers(
    val icon: Int,
    val label: String
)