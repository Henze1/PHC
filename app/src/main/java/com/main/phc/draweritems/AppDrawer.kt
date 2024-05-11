package com.main.phc.draweritems

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
    var vitaminPopupVisible by remember { mutableStateOf(false) }
    var hygienePopupVisible by remember { mutableStateOf(false) }
    var herbsPopupVisible by remember { mutableStateOf(false) }
    var babyPopupVisible by remember { mutableStateOf(false) }

    ModalDrawerSheet(
    modifier = Modifier
    .border(
    width = 1.dp,
    color = Color.Black,
    shape = MaterialTheme.shapes.large
    ),
    drawerContainerColor = Color.White
    ) {
        DrawerHeader(modifier)

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
                    text = "\tHome",
                    color = Color.Black)
            },
            selected = route == AllDestinations.VITAMINS,
            onClick = {
                navigateToHome()
                closeDrawer()
            },
            icon = {
                Image(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.navtohome),
                    contentDescription = "Home"
                )
            }
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Vitamins",
                        color = Color.Black
                    )
                    IconButton(
                        onClick = {
                            vitaminPopupVisible = !vitaminPopupVisible
                        }) {
                        Icon(
                            imageVector =
                                if (vitaminPopupVisible) {
                                    Icons.Default.KeyboardArrowUp
                                } else {
                                    Icons.Default.KeyboardArrowDown
                                } ,
                            contentDescription = null,
                            tint = Color.DarkGray
                        )
                    }
                }
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

        if ( vitaminPopupVisible) {
            CardItem()
        }


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
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Hygiene",
                        color = Color.Black
                    )
                    IconButton(
                        onClick = {
                            hygienePopupVisible = !hygienePopupVisible
                        }) {
                        Icon(
                            imageVector =
                            if (hygienePopupVisible) {
                                Icons.Default.KeyboardArrowUp
                            } else {
                                Icons.Default.KeyboardArrowDown
                            } ,
                            contentDescription = null,
                            tint = Color.DarkGray
                        )
                    }
                }
            },
            selected = route == AllDestinations.VITAMINS,
            onClick = {
                //TODO("Implement")
                navigateToVitamins()
                closeDrawer()
            },
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.hygiene),
                    contentDescription = "Hygiene"
                )
            }
        )

        if (hygienePopupVisible) {
            CardItem()
        }

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
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Herbs",
                        color = Color.Black
                    )
                    IconButton(
                        onClick = {
                            herbsPopupVisible = !herbsPopupVisible
                        }) {
                        Icon(
                            imageVector = if (herbsPopupVisible) { Icons.Default.KeyboardArrowUp} else { Icons.Default.KeyboardArrowDown} ,
                            contentDescription = null,
                            tint = Color.DarkGray
                        )
                    }
                }
            },
            selected = route == AllDestinations.VITAMINS,
            onClick = {
                //TODO("Implement")
                navigateToVitamins()
                closeDrawer()
            },
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.herbs),
                    contentDescription = "Herbs"
                )
            }
        )

        if (herbsPopupVisible) {
            CardItem()
        }

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
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Baby",
                        color = Color.Black
                    )
                    IconButton(
                        onClick = {
                            babyPopupVisible = !babyPopupVisible
                        }) {
                        Icon(
                            imageVector = if (babyPopupVisible) { Icons.Default.KeyboardArrowUp} else { Icons.Default.KeyboardArrowDown},
                            contentDescription = null,
                            tint = Color.DarkGray
                        )
                    }
                }
            },
            selected = route == AllDestinations.VITAMINS,
            onClick = {
                //TODO("Implement")
                navigateToVitamins()
                closeDrawer()
            },
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.baby),
                    contentDescription = "Baby"
                )
            }
        )

        if (babyPopupVisible) {
            CardItem()
        }
    }
}
@Composable
fun DrawerHeader(
    modifier: Modifier
) {
    var inputText by remember { mutableStateOf("") }
    NavigationDrawerItem(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .border(
                width = 1.dp,
                color = Color.Black
            )
            .background(
                color = Color(0xFF228B22)
            ),
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = Color(0xFF228B22),
            unselectedContainerColor = Color(0xFF228B22)
        ),
        selected = false,
        onClick = {},
        label = {
            OutlinedTextField(
                modifier = Modifier.
                fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedTextColor = Color.Black,
                    focusedTextColor = Color.Black
                ),
                value = inputText,
                onValueChange = {
                    inputText = it
                },
                placeholder = {
                    Text(
                        text = "Search",
                        color = Color.Black
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            //TODO("Implement")
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                tint = Color.DarkGray
                            )
                        }
                    )
                },
                shape = RoundedCornerShape(28.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        //TODO("Implement")
                    }
                ),
                singleLine = true
            )
        }
    )
}

@Composable
fun CardItem(){
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clickable(
                    onClick = {
                        //TODO("Implement")
                    }
                ),
            text = "Կանացի",
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clickable(
                    onClick = {
                        //TODO("Implement")
                    }
                ),
            text = "Տղամարդու",
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clickable(
                    onClick = {
                        //TODO("Implement")
                    }
                ),
            text = "Մանկական",
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clickable(
                    onClick = {
                        //TODO("Implement")
                    }
                ),
            text = "Գեղեցկություն",
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clickable(
                    onClick = {
                        //TODO("Implement")
                    }
                ),
            text = "Սպորտ",
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clickable(
                    onClick = {
                        //TODO("Implement")
                    }
                ),
            text = "Այլ․․․",
            textAlign = TextAlign.Center,
        )
    }
}
@Preview(showBackground = true)
@Composable
fun AppDrawerPreview() {
    AppDrawer(route = AllDestinations.HOME, navigateToHome = {}, navigateToVitamins = {}, closeDrawer = {})
}