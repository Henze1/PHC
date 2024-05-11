package com.main.phc.inside

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.phc.R
import com.main.phc.ui.theme.loadImageFromUrl
import kotlinx.coroutines.launch
import java.util.UUID

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Vitamins(
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    val memberImagesLinks: List<String> = listOf(
        "https://pharmcenter.am/storage/products/00-00001961.webp",
        "https://pharmcenter.am/storage/products/00-00001963.webp",
        "https://pharmcenter.am/storage/products/00-00001497.webp",
        "https://pharmcenter.am/storage/products/00-00001270.webp",
        "https://pharmcenter.am/storage/products/00-00000278.webp",
        "https://pharmcenter.am/storage/products/00-00001225.webp",
        "https://pharmcenter.am/storage/products/00-00001098.webp",
        "https://pharmcenter.am/storage/products/00-00000063.webp",
        "https://pharmcenter.am/storage/products/MO017475.webp",
        "https://pharmcenter.am/storage/products/MO017475.webp",
        "https://pharmcenter.am/storage/products/MO008839.webp",
        "https://pharmcenter.am/storage/products/00-00000187.webp"
    )

    val memberForGridImages: ArrayList<Member> = ArrayList()
    memberImagesLinks.forEach {
        memberForGridImages.add(Member(loadImageFromUrl(it)))
    }

    val images: List<Int> = listOf(
        R.drawable.brandimg,
        R.drawable.homepg,
        R.drawable.cart1img,
        R.drawable.favorites1
    )

    val topRawImages: ArrayList<MemberForRaw> = ArrayList()

    images.forEach {
        topRawImages.add(
            MemberForRaw(
                image = painterResource(id = it),
                name = "Top"
            )
        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            verticalArrangement = Arrangement.Top,
        )
        {
            ImageSweepableRow(images = topRawImages)
        }

        //TODO: Add List of members
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(4.dp),
            content = {
                items(
                    key = {
                        memberForGridImages[it].id
                    },
                    count =  memberForGridImages.size
                ) {index ->
                    Column(
                        modifier = Modifier
                            .height(400.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.LightGray)
                            .border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .clickable(
                                onClick = {
                                    // TODO("Handle click event")
                                }
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .width(300.dp)
                                .height(300.dp)
                        ) {
                            Image(
                                painter = memberForGridImages[index].image,
                                contentDescription = memberForGridImages[index].id,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .border(
                                        width = 1.dp,
                                        color = Color.Black,
                                        shape = RoundedCornerShape(5.dp)
                                    ),
                            )
                        }
                        Text(text = "Herbs",
                            color = Color.Black
                        )
                    }
                }
            }
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column {
            FloatingActionButton(
                containerColor = Color.White,
                contentColor = Color.White,
                shape = CircleShape,
                onClick = {
                        //TODO("Add click logic here")
                },
                modifier = Modifier
                    .padding(16.dp),
                content = {
                    Image(
                        modifier = Modifier
                            .size(50.dp),
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        colorFilter = ColorFilter.tint(Color(0xFF228B22))
                    )
                }
            )

            FloatingActionButton(
                containerColor = Color.White,
                contentColor = Color.White,
                shape = CircleShape,
                onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                },
                modifier = Modifier
                    .padding(16.dp),
                content = {
                    Image(
                        modifier = Modifier
                            .size(56.dp),
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "Menu"
                    )
                }
            )
        }
    }
}

data class Member(
    val image: Painter,
    val id: String = UUID.randomUUID().toString()
)
@Preview(showBackground = true)
@Composable
fun VitaminsPreview() {
    Vitamins( drawerState = DrawerState(initialValue = DrawerValue.Closed))
}