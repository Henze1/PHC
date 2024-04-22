package com.main.phc.inside

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.phc.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPage() {
    val searchText by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }

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
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        Spacer(modifier = Modifier.width(4.dp))
                        IconButton(
                            onClick = { expanded = true },
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
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.menu),
                                contentDescription = "Menu"
                            )
                        }

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text(text = "Settings") },
                                onClick = { expanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text(text = "Help") },
                                onClick = { expanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text(text = "About") },
                                onClick = { expanded = false }
                            )
                        }


                        TextField(
                            value = searchText,
                            onValueChange = {isSearching = false},
                            placeholder = {
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                    Text(
                                        text = "Search",
                                        color = Color.Black
                                    )
                                }
                            },
                            modifier = Modifier.padding(horizontal = 8.dp),
                            shape = MaterialTheme.shapes.small
                        )
                        IconButton(
                            onClick = { expanded = true },
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
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.favorites1),
                                contentDescription = "Favorites"
                            )
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
                            painter =  painterResource(id = R.drawable.cart1img),
                            contentDescription = "Purchases")
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
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Recommendations",
                color = Color.DarkGray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 24.sp,
                    shadow = Shadow(
                        color = Color.Blue, offset = Offset.Infinite, blurRadius = 3f
                    )
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                LazyRow(
                    state = LazyListState(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(5) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.brandimg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.brandimg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                LazyRow(
                    state = LazyListState(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(5) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.brandimg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.brandimg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Last Searches",
                color = Color.DarkGray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 24.sp,
                    shadow = Shadow(
                        color = Color.Blue, offset = Offset.Infinite, blurRadius = 3f
                    )
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                LazyRow(
                    state = LazyListState(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(5) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.brandimg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.brandimg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                LazyRow(
                    state = LazyListState(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(5) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.brandimg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.brandimg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                        Image(
                            painter = painterResource(
                                id = R.drawable.homepg
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {

                                }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ImageSweepableRow(imageIds: List<Int>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(imageIds.size) { index ->
            val imageId = imageIds[index]
//            val imageBitmap = imageResource(id = imageId).value.asImageBitmap()
            Image(
                bitmap = ImageBitmap(10, 10),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(100.dp) // Adjust size as needed
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    MainPage()
}