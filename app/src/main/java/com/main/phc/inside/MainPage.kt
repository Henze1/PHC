package com.main.phc.inside

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.phc.R
import kotlinx.coroutines.launch
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPage(
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        containerColor = Color(0xFFE9E9E9),
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFF228B22),
                ),
                title = { Text(text = "") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                actions = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        IconButton(
                            onClick = {
                                //TODO("Implement")
                            },
                            modifier = Modifier
                                .background(
                                    shape = MaterialTheme.shapes.extraLarge,
                                    color = Color(0xFFffffff)
                                )
                                .border(
                                    2.dp,
                                    Color(0xFF228B22),
                                    shape = MaterialTheme.shapes.extraLarge
                                )
                            ,
                        )
                        {
//                            Icon(
//                                imageVector = Icons.Default.MoreVert,
//                                imageVector = Icons.AutoMirrored.Filled.List,
//                                contentDescription = "Menu",
//                                tint = Color(0xFF228B22)
//                            )
                            Image(
                                painter =  painterResource(id = R.drawable.menuuu),
                                contentDescription = "menu"
                            )
                        }

                        Box(
                            modifier = Modifier
                                .width(280.dp)
                        ){
                            OutlinedTextField(
                                modifier = Modifier.
                                fillMaxWidth(),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.White,
                                    focusedContainerColor = Color.White,
                                    unfocusedTextColor = Color.Black,
                                    focusedTextColor = Color.Black
                                ),
                                value = searchText,
                                onValueChange = {
                                    searchText = it
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
                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .background(
                                    shape = MaterialTheme.shapes.extraLarge,
                                    color = Color(0xFFFFFFFF)
                                )
                                .border(
                                    2.dp,
                                    Color(0xFF228B22),
                                    shape = MaterialTheme.shapes.extraLarge
                                )
                        )
                        {
                            Image(
                                painter =  painterResource(id = R.drawable.cart1img),
                                contentDescription = "Purchases")
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                containerColor = Color(0xFF228B22)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .background(
                                shape = MaterialTheme.shapes.extraLarge,
                                color = Color(0xFFFFFFFF)
                            )
                            .border(
                                2.dp,
                                Color(0xFF228B22),
                                shape = MaterialTheme.shapes.extraLarge
                            )
                        )
                    {
                        Image(
                            painter =  painterResource(id = R.drawable.homepg),
                            contentDescription = "Home"
                        )
                    }
                    IconButton(
                        onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        },
                        modifier = Modifier
                            .background(
                                shape = MaterialTheme.shapes.extraLarge,
                                color = Color(0xFFffffff)
                            )
                            .border(
                                2.dp,
                                Color(0xFF228B22),
                                shape = MaterialTheme.shapes.extraLarge
                            )
                        ,
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "Menu"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .background(
                                shape = MaterialTheme.shapes.extraLarge,
                                color = Color(0xFFFFFFFF)
                            )
                            .border(
                                2.dp,
                                Color(0xFF228B22),
                                shape = MaterialTheme.shapes.extraLarge
                            )
                    )
                    {
                        Image(
                            painter =  painterResource(id = R.drawable.brandimg),
                            contentDescription = "Brands")
                    }
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .background(
                                shape = MaterialTheme.shapes.extraLarge,
                                color = Color(0xFFFFFFFF)
                            )
                            .border(
                                2.dp,
                                Color(0xFF228B22),
                                shape = MaterialTheme.shapes.extraLarge
                            )
                    )
                    {
                        Image(
                            painter =  painterResource(id = R.drawable.userimg),
                            contentDescription = "User")
                    }
                }
            }
        }
    )
    {
        innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.height(2.dp))
            Image(
                painter = painterResource(
                    id = R.drawable.img_6
                ),
                contentDescription = null
            )

            val images: List<Int> = listOf(
                R.drawable.brandimg,
                R.drawable.homepg,
                R.drawable.cart1img,
                R.drawable.favorites1
            )

            val membersForRow: ArrayList<MemberForRaw> = ArrayList()

            images.forEach {
                membersForRow.add(
                    MemberForRaw(
                        image = painterResource(id = it),
                        name = "Member $it"
                    )
                )
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Text(
                        text = "\t\tՄանկական Սնունդ",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ImageSweepableRow(images = membersForRow)
                }

                item {
                    Text(
                        text = "\t\tԼավագույնը՝ ձեր փոքրիկի համար",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ImageSweepableRow(images = membersForRow)
                }

                item {
                    Text(
                        text = "\t\tՄիշտ գեղեցիկ և խնամված",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ImageSweepableRow(images = membersForRow)
                }

                item {
                    Text(
                        text = "\t\tՍեզոնային ապրանքներ",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ImageSweepableRow(images = membersForRow)
                }

                item {
                    Text(
                        text = "\t\tԲրենդ - Դիտել բոլորը",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ImageSweepableRow(images = membersForRow)
                }
            }
        }
    }
}
@Composable
fun ImageSweepableRow(images: List<MemberForRaw>) {

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    )
    {
        items(
            key = {
                images[it].id
            },
            count = images.size
        )
        { index ->
            Image(
                painter = images[index].image,
                contentDescription = images[index].name,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(100.dp)
                    .clickable {
                    //TODO("Add click logic here")
                    }
                )
            }
        }
}


data class MemberForRaw(
    val image: Painter,
    val name: String,
    val id: String = UUID.randomUUID().toString()
)
@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    MainPage(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed))
}