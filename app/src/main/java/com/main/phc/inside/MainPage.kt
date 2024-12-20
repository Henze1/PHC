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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.main.phc.AppNavigation.Companion.setRoute
import com.main.phc.R
import com.main.phc.draweritems.CartBottomSheet
import com.main.phc.inside.AllDestinations.HOME
import com.main.phc.inside.AllDestinations.PRODUCT
import com.main.phc.ui.theme.loadImageFromUrl
import com.main.phc.viewmodels.MemberViewModel
import com.main.phc.viewmodels.MemberViewModel.Companion.memberList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPage(
    drawerState: DrawerState,
    navController: NavHostController,
    memberViewModel: MemberViewModel
) {
    val catalogMemberImagesLinks: List<String> = listOf(
        "https://pharmcenter.am/storage/products/00-00001961.webp Магния_цитрат_капс_600мг_х_60 4800_դր Արտադրող Երկիր",
        "https://pharmcenter.am/storage/products/00-00001963.webp Магне-В6_капс_400мг_х_90 5200_դր Արտադրող Երկիր",
        "https://pharmcenter.am/storage/products/00-00001497.webp Омега_3_капс.1000мг_х_60 8075_դր Արտադրող Երկիր",
        "https://pharmcenter.am/storage/products/00-00001270.webp Դուոսլիմ_էքսպերտ_պատիճներ_№60 3825_դր Արտադրող Երկիր",
        "https://pharmcenter.am/storage/products/00-00000278.webp Янтарная_кислота_форте_400мг_таб_х_30 3100_դր Արտադրող Երկիր",
        "https://pharmcenter.am/storage/products/00-00001225.webp Նիկոտինաթթու_10_մգ/մլ_1մլ_-_1%_լուծույթ_ներարկման_ն/ե,_մ/մ_,_ե/մ_սրվակներ_№10 1200_դր Արտադրող Երկիր",
        "https://pharmcenter.am/storage/products/00-00001098.webp Альфа-липоевая_кислота_форте_таб_п/о_100мг_х_30 3250_դր Արտադրող Երկիր",
        "https://pharmcenter.am/storage/products/00-00000063.webp Витрум_Кидс_плюс_с_3_до_7лет_с_йодом_таб._х_30 5000_դր Արտադրող Երկիր",
        "https://pharmcenter.am/storage/products/MO017475.webp Nestle_Ֆիթնես 230_դր producer country",
        "https://pharmcenter.am/storage/products/MO008839.webp Մեզիմ_ֆորտե_դհտ._N20 800_դր producer country",
        "https://pharmcenter.am/storage/products/00-00000187.webp Ինտենորմ_(Բուլարդի_+_Պրոբիո_կոմպլեքս)_400մգ_դեղապատիճ_№30 11000_դր producer country"
    )

    val memberForCatalogImages: ArrayList<Member> = ArrayList()
    catalogMemberImagesLinks.forEach {
        val member = it.split(" ")
        memberForCatalogImages.add(
            Member(
                image =  loadImageFromUrl(member[0]),
                name =  member[1],
                price =  member[2],
                producer = member[3],
                producerCountry = member[4]
            )
        )
    }
    val headerImagesLinks: List<String> = listOf(
        "https://pharmcenter.am/storage/home-sliders/April2024/F2vwhpaIcSvAbt2yMmG5.webp",
        "https://pharmcenter.am/storage/home-sliders/April2024/APu08QTEZeUUAggYQKlK.webp",
        "https://pharmcenter.am/storage/home-sliders/April2024/glRkI2mtzYNgEHzSSUm5.webp",
        "https://pharmcenter.am/storage/home-sliders/April2024/zyqZpX6I9h6KjeNRbeTp.jpeg",
        "https://pharmcenter.am/storage/home-sliders/November2023/wkazXBXAwraKPaPqeXBh.jpeg"
    )

    val headerImages: ArrayList<Painter> = ArrayList()
    headerImagesLinks.forEach {
        headerImages.add(loadImageFromUrl(it))
    }

    val scope = rememberCoroutineScope()

    var searchText by remember { mutableStateOf("") }

    var showBottomSheet by remember { mutableStateOf(false) }

    var isMenuExpanded by remember { mutableStateOf(false) }

    var isSearchExpanded by remember { mutableStateOf(false) }
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
                        Box {
                            IconButton(
                                onClick = {
                                    isMenuExpanded = !isMenuExpanded
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
                                    ),
                            )
                            {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "Menu",
                                    tint = Color(0xFF228B22)
                                )
                            }

                            DropdownMenu(
                                expanded = isMenuExpanded,
                                onDismissRequest = { isMenuExpanded = false }
                            ) {
                                DropdownMenuItem(
                                    onClick = {
                                        isMenuExpanded = false
                                        //TODO("Implement the rest of the menu items")
                                    },
                                    text = { Text(text = "English") }
                                )
                                DropdownMenuItem(
                                    onClick = {
                                        isMenuExpanded = false
                                        //TODO("Implement the rest of the menu items")
                                    },
                                    text = { Text(text = "English") }
                                )
                                DropdownMenuItem(
                                    onClick = {
                                        isMenuExpanded = false
                                        //TODO("Implement the rest of the menu items")
                                    },
                                    text = { Text(text = "English") }
                                )
                            }
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
                                            isSearchExpanded = !isSearchExpanded
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

                            DropdownMenu(
                                modifier = Modifier
                                    .width(280.dp),
                                expanded = isSearchExpanded,
                                onDismissRequest = { isSearchExpanded = false }
                            )
                            {
                                DropdownMenuItem(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    onClick = {
                                        isSearchExpanded = false
                                        //TODO("Implement the rest of the search options")
                                    },
                                    text = { Text(text = "English") }
                                )
                                DropdownMenuItem(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    onClick = {
                                        isSearchExpanded = false
                                        //TODO("Implement the rest of the search options")
                                    },
                                    text = { Text(text = "English") }
                                )
                                DropdownMenuItem(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    onClick = {
                                        isSearchExpanded = false
                                        //TODO("Implement the rest of the search options")
                                    },
                                    text = { Text(text = "English") }
                                )

                            }
                        }
                        IconButton(
                            onClick = {
                            //TODO("Implement")
                            showBottomSheet = true
                            },
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
                        if (showBottomSheet) {
                            @Suppress("KotlinConstantConditions")
                            CartBottomSheet(
                                scope = scope,
                                showBottomSheet = showBottomSheet,
                                closeDrawer = {
                                    scope.launch { drawerState.close() }
                                        .invokeOnCompletion { showBottomSheet = false }
                                }
                            )
                            {
                                SheetContent()
                            }
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
                        onClick = {
                            //TODO("Implement")
                        },
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
                    IconButton(
                        onClick = {
                            //TODO("Implement")
                        },
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
                    IconButton(
                        onClick = {
                            //TODO("Implement")
                        },
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

            AutoSweepableHeaderImages(images = headerImages)

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


            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "\t\tՄանկական Սնունդ",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CatalogImageSweepableRow(
                        images = memberForCatalogImages,
                        memberViewModel = memberViewModel,
                        navController = navController
                    )
                }

                item {
                    Text(
                        text = "\t\tԼավագույնը՝ ձեր փոքրիկի համար",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CatalogImageSweepableRow(
                        images = memberForCatalogImages,
                        memberViewModel = memberViewModel,
                        navController = navController
                    )
                }

                item {
                    Text(
                        text = "\t\tՄիշտ գեղեցիկ և խնամված",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CatalogImageSweepableRow(
                        images = memberForCatalogImages,
                        memberViewModel = memberViewModel,
                        navController = navController
                    )
                }

                item {
                    Text(
                        text = "\t\tՍեզոնային ապրանքներ",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CatalogImageSweepableRow(
                        images = memberForCatalogImages,
                        memberViewModel = memberViewModel,
                        navController = navController
                    )
                }

                item {
                    Text(
                        text = "\t\tԲրենդ - Դիտել բոլորը",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CatalogImageSweepableRow(
                        images = memberForCatalogImages,
                        memberViewModel = memberViewModel,
                        navController = navController
                    )
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 8.dp, bottom = 100.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
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
    }
}
@Composable
fun CatalogImageSweepableRow(
    images: List<Member>,
    memberViewModel: MemberViewModel,
    navController: NavHostController
) {
    val selectedItems = remember { mutableStateListOf<Boolean>().apply { addAll(images.map { it.isSelected }) } }


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
            Column(
                modifier = Modifier
                    .height(275.dp)
                    .width(150.dp)
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
                            setRoute(HOME)
                            memberViewModel.member = images[index]
                            navController.navigate(PRODUCT)
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
                        painter = images[index].image,
                        contentDescription = images[index].id,
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(5.dp)
                            ),
                    )
                    FavoriteIconButtonOnMainPage(
                        isSelected = selectedItems[index],
                        onClick = {
                            selectedItems[index] = !selectedItems[index]
//                            TODO(
//                                  "if userExits add to favorites" +
//                                  "else redirect to login/signup page"
//                            )
                        },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(4.dp)
                            .size(50.dp)
                    )
                    Text(
                        text = images[index].producer,
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
                    text = images[index].name.replace("_", " "),
                    color = Color.Black,
                    maxLines = 2,
                    minLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp,
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
                        text = images[index].price.replace("_", " "),
                        color = Color(0xFF228B22),
                        fontSize = 12.sp
                    )
                    Text(
                        maxLines = 1,
                        modifier = Modifier
                            .padding(end = 20.dp),
                        text = images[index].price.replace("_", " "),
                        fontSize = 12.sp,
                        color = Color.Red,
                        style = TextStyle(
                            textDecoration = TextDecoration.LineThrough,
                        )
                    )

                }

                Button(
                    colors = ButtonDefaults.buttonColors( Color(0xFF228B22)),
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                        .size(width = 100.dp, height = 35.dp),
                    onClick = {
                        //TODO("Add click logic here")

                        if(memberList.contains(images[index])) {
                            images[index].count++
                        } else {
                            memberList.add(images[index])
                        }
                    }) {
                    Row {
                        Text(text = "Add", color = Color.White, fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null, tint = Color.White)
                    }
                }
            }
        }
    }
}
@Composable
fun AutoSweepableHeaderImages(images: List<Painter>, changeInterval: Long = 3000L) {
    var currentIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(changeInterval)
            currentIndex = Random.nextInt(images.size)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 155.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = images[currentIndex],
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}



@Composable
fun FavoriteIconButtonOnMainPage(
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
@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    MainPage(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
        navController = rememberNavController(),
        memberViewModel = MemberViewModel()
    )
}