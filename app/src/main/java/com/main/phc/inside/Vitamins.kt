package com.main.phc.inside

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.phc.R
import com.main.phc.ui.theme.loadImageFromUrl
import kotlinx.coroutines.launch
import java.util.UUID


@Composable
fun Vitamins(
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    val memberImagesLinks: List<String> = listOf(
        "https://pharmcenter.am/storage/products/00-00001961.webp Магния_цитрат_капс_600мг_х_60 4800_դր",
        "https://pharmcenter.am/storage/products/00-00001963.webp Магне-В6_капс_400мг_х_90 5200_դր",
        "https://pharmcenter.am/storage/products/00-00001497.webp Омега_3_капс.1000мг_х_60 8075_դր",
        "https://pharmcenter.am/storage/products/00-00001270.webp Դուոսլիմ_էքսպերտ_պատիճներ_№60 3825_դր",
        "https://pharmcenter.am/storage/products/00-00000278.webp Янтарная_кислота_форте_400мг_таб_х_30 3100_դր",
        "https://pharmcenter.am/storage/products/00-00001225.webp Նիկոտինաթթու_10_մգ/մլ_1մլ_-_1%_լուծույթ_ներարկման_ն/ե,_մ/մ_,_ե/մ_սրվակներ_№10 1200_դր",
        "https://pharmcenter.am/storage/products/00-00001098.webp Альфа-липоевая_кислота_форте_таб_п/о_100мг_х_30 3250_դր",
        "https://pharmcenter.am/storage/products/00-00000063.webp Витрум_Кидс_плюс_с_3_до_7лет_с_йодом_таб._х_30 5000_դր",
        "https://pharmcenter.am/storage/products/MO017475.webp Nestle_Ֆիթնես 230_դր",
        "https://pharmcenter.am/storage/products/MO008839.webp Մեզիմ_ֆորտե_դհտ._N20 800_դր",
        "https://pharmcenter.am/storage/products/00-00000187.webp Ինտենորմ_(Բուլարդի_+_Պրոբիո_կոմպլեքս)_400մգ_դեղապատիճ_№30 11000_դր"
    )

    val gridItems: ArrayList<Member> = ArrayList()
    memberImagesLinks.forEach {
        val member = it.split(" ")
        gridItems.add(Member(loadImageFromUrl(member[0]), member[1], member[2]))
    }

    val selectedItems = remember { mutableStateListOf<Boolean>().apply { addAll(gridItems.map { it.isSelected }) } }


    val images: List<Int> = listOf(
        R.drawable.brandimg,
        R.drawable.navtohome,
        R.drawable.cart1img,
        R.drawable.favorites1,
        R.drawable.userimg
    )

    val topRawImages: ArrayList<Member> = ArrayList()

    images.forEach {
        topRawImages.add(
            Member(
                image = painterResource(id = it),
                name = "Top",
                price = "Price: 1000AMD"
            )
        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        ImageSweepableRowForCatalog(images = topRawImages)

        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(
            modifier = Modifier
                .blur(10.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(5.dp)
                ),
            thickness = 4.dp,
            color = Color.Gray
        )

        // TODO("Add List of members")

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(4.dp),
            content = {
                items(
                    key = {
                        gridItems[it].id
                    },
                    count =  gridItems.size
                ) {index ->
                    Column(
                        modifier = Modifier
                            .height(320.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.White)
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .clickable(
                                onClick = {
                                    TODO("Handle click event")
                                }
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .background(
                                    color = Color(0xFFE9EAEC),
                                    shape = RoundedCornerShape(5.dp)
                                )
                        ) {
                            Image(
                                painter = gridItems[index].image,
                                contentDescription = gridItems[index].id,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .border(
                                        width = 1.dp,
                                        color = Color.LightGray,
                                        shape = RoundedCornerShape(5.dp)
                                    ),
                            )
                            FavoriteIconButtonOnVitaminsPage(
                                isSelected = selectedItems[index],
                                onClick = {
                                    selectedItems[index] = !selectedItems[index]
//                                    TODO(
//                                        "if userExits add to favorites" +
//                                                "else redirect to login/signup page"
//                                    )
                                },
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(4.dp)
                                    .size(50.dp)
                            )

                            Text(
                                text = "Ֆարմակոր Պրոդաքշն",
                                color = Color.Green,
                                textAlign = TextAlign.Start,
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .padding(6.dp)
                                    .background(
                                        color = Color.White,
                                        shape = RoundedCornerShape(4.dp)
                                    ),
                                fontSize = 8.sp
                            )
                        }
                        Text(
                            modifier = Modifier
                                .padding(start = 8.dp),
                            text = gridItems[index].name.replace("_", " "),
                            color = Color.Black,
                            maxLines = 2,
                            minLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(2.dp))
                        HorizontalDivider(
                            modifier = Modifier
                                .padding(start = 8.dp, end = 8.dp),
                            thickness = 1.dp,
                            color = Color.LightGray
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(start = 30.dp),
                                text = gridItems[index].price.replace("_", " "),
                                color = Color(0xFF228B22),
                            )
                            Text(
                                maxLines = 1,
                                modifier = Modifier
                                    .padding(end = 20.dp),
                                text = gridItems[index].price.replace("_", " "),
                                color = Color.Red,
                                style = TextStyle(
                                    textDecoration = TextDecoration.LineThrough,
                                )
                            )

                        }

                        Button(
                            colors = ButtonDefaults.buttonColors( Color(0xFF228B22)),
                            modifier = Modifier
                                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                            onClick = {
                                TODO("Add click logic here")
                        }) {
                            Row {
                                Text(text = "Add to cart", color = Color.White, fontSize = 14.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null, tint = Color.White)
                            }
                        }
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
                        TODO("Add click logic here")
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

@Composable
fun FavoriteIconButtonOnVitaminsPage(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val icon = if (isSelected) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder
    IconButton(
        onClick = onClick,
        modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = Color(0xFF228B22)
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
    }
}

@Composable
fun ImageSweepableRowForCatalog(images: List<Member>) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    )
    {
        items(
            key = {
                images[it].id
            },
            count = images.size
        )
        { index ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF228B22),
                        shape = RoundedCornerShape(5.dp)
                    )
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = images[index].image,
                    contentDescription = images[index].name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .clickable {
                            TODO("Add click logic here")
                        }
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    text = "name",
                    color = Color(0xFF228B22),
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

data class Member(
    val image: Painter,
    val name: String,
    val price: String,
    val id: String = UUID.randomUUID().toString(),
    var icon: ImageVector = Icons.Default.FavoriteBorder,
    var isSelected: Boolean = false
)
@Preview(showBackground = true)
@Composable
fun VitaminsPreview() {
    Vitamins( drawerState = DrawerState(initialValue = DrawerValue.Closed))
}