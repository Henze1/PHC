package com.main.phc.inside

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import com.main.phc.R

@Suppress("UNUSED_EXPRESSION")
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPage(onMenuIconClick: () -> Unit) {
    var searchText by remember { mutableStateOf("") }
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
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        IconButton(
                            onClick = {
                                onMenuIconClick
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
            Text(
                text = "\tRecommendations",
                fontSize = 26.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 24.sp,
                    shadow = Shadow(
                        color = Color.Blue, offset = Offset.Infinite, blurRadius = 3f
                    )
                )
            )


            val images: List<Int> = listOf(
                R.drawable.brandimg,
                R.drawable.homepg,
                R.drawable.cart1img,
                R.drawable.favorites1,
                R.drawable.favorites)

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
                    ImageSweepableRow(imageIds = images)
                }

                item {
                    Text(
                        text = "\t\tԼավագույնը՝ ձեր փոքրիկի համար",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ImageSweepableRow(imageIds = images)
                }

                item {
                    Text(
                        text = "\t\tՄիշտ գեղեցիկ և խնամված",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ImageSweepableRow(imageIds = images)
                }

                item {
                    Text(
                        text = "\t\tՍեզոնային ապրանքներ",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ImageSweepableRow(imageIds = images)
                }

                item {
                    Text(
                        text = "\t\tԲրենդ - Դիտել բոլորը",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ImageSweepableRow(imageIds = images)
                }
            }
        }
    }
}
@Composable
fun ImageSweepableRow(imageIds: List<Int>) {
    val context = LocalContext.current

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(imageIds.size) { index ->
            val imageId = imageIds[index]
            val imageBitmap = imageBitmapFromResource(context, imageId)
            imageBitmap?.let {
                Image(
                    bitmap = it,
                    contentDescription = null,
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
}

fun imageBitmapFromResource(context: Context, imageResId: Int): ImageBitmap? {
    return try {
        val imageDrawable = context.getDrawable(imageResId)
        imageDrawable?.toBitmap()?.asImageBitmap()
    } catch (e: Exception) {
        null
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    MainPage {}
}