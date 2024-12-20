package com.main.phc.inside

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.main.phc.AppNavigation.Companion.getRoute
import com.main.phc.R
import com.main.phc.draweritems.CartBottomSheet
import com.main.phc.viewmodels.MemberViewModel.Companion.memberList
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Product(
    navController: NavHostController,
    drawerState: DrawerState,
    member: Member
) {
    val itemCount = remember { mutableIntStateOf(member.count) }
    var searchText by remember { mutableStateOf("") }
    var showBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme
                    .colorScheme
                    .background
            ),
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF228B22),
            ),
            title = { Text(text = "") },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            actions = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentAlignment = Alignment.CenterEnd
                ){
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = TextFieldDefaults.colors(
                            selectionColors = TextSelectionColors(
                                handleColor = Color.Blue,
                                backgroundColor = Color.White
                            ),
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
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Box {
                    Image(
                        painter = member.image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                    )
                    IconButton(
                        onClick = {
                            navController.navigate(getRoute())
                        },
                        modifier = Modifier
                            .align(Alignment.TopStart)
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                }
                VerticalDivider()
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = member.name.replace("_", " "),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )

                    if (member.producerCountry != "") {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Երկ: " + member.producerCountry,
                            maxLines = 1,
                            minLines = 1,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        )
                    }

                    if (member.producer != "") {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Արտդ: " + member.producer,
                            maxLines = 1,
                            minLines = 1,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        )
                    }

                    Text(
                        textAlign = TextAlign.Center,
                        text = "կոդ։ " + member.id,
                        maxLines = 2,
                        minLines = 1,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                }
            }
            HorizontalDivider()

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {

                Row(
                    modifier = Modifier
                        .width(113.dp)
                        .height(30.dp)
                        .background(
                            color = Color(0xFF228B22),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    IconButton(
                        onClick = {
                            --itemCount.intValue
                            if (itemCount.intValue < 1) itemCount.intValue = 1
                            member.count = itemCount.intValue
                        },
                        modifier = Modifier
                            .width(40.dp)
                            .height(30.dp)
                    ) {
                        HorizontalDivider(
                            modifier = Modifier
                                .width(15.dp),
                            thickness = 2.dp,
                            color = Color.Black
                        )
                    }
                    VerticalDivider(
                        color = Color.Black,
                        thickness = 1.dp
                    )
                    Text(
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .width(30.dp)
                            .align(Alignment.CenterVertically),
                        text = itemCount.intValue.toString(),
                        fontSize = 20.sp
                    )
                    VerticalDivider(
                        color = Color.Black,
                        thickness = 1.dp
                    )
                    IconButton(
                        onClick = {
                            ++itemCount.intValue
                            member.count = itemCount.intValue
                        },
                        modifier = Modifier
                            .width(40.dp)
                            .height(30.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }
                Text(
                    textAlign = TextAlign.Center,
                    text = (member.price.replace("_դր", "").toInt() * itemCount.intValue).toString() + " դր",
                    maxLines = 5,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
            HorizontalDivider()
            Button(
                onClick = {
                    //TODO("Implement")
                    if(memberList.contains(member)) {
                        member.count++
                    } else {
                        memberList.add(member)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF228B22),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Add to cart",
                    color = Color.White
                )
            }
            HorizontalDivider()

            Text(
                text = "Նմանատիպ ապրանքներ",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
            )
        }

        //TODO("replace with actual bottom sheet")
        Text(
            textAlign = TextAlign.Center,
            text = "Այս դաշտը դեռևս ազատ է",
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            minLines = 2
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 8.dp, bottom = 8.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            containerColor = Color.White,
            contentColor = Color.White,
            shape = CircleShape,
            onClick = {
                showBottomSheet = true
            },
            modifier = Modifier
                .padding(16.dp),
            content = {
                Image(
                    modifier = Modifier
                        .size(50.dp),
                    painter = painterResource(id = R.drawable.cart1img),
                    contentDescription = "Email",
                    colorFilter = ColorFilter.tint(Color(0xFF228B22))
                )
            }
        )
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

@Preview(showBackground = true)
@Composable
fun ProductPreview() {
    Product(
        navController = NavHostController(LocalContext.current),
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
        member = Member(
            image = painterResource(id = R.drawable.userimg),
            name = "A product with a long name",
            price = "7980",
            producer = "Producer",
            producerCountry = "Country",
            id = "123456789"
        )
    )
}
