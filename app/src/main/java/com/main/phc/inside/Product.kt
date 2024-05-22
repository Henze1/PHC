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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.phc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Product(
    member: Member,
) {
    var searchText by remember { mutableStateOf("") }
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
            }
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                ) {
                    Image(
                        painter = member.image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                    )
                    Column {
                        Text(
                            text = member.name,
                            maxLines = 5,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )
                        Text(
                            text = member.price + " դր",
                            maxLines = 5,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )

//                        var sliderPosition by remember { mutableIntStateOf(1) }
//                        Column {
//                            Slider(
//                                value = sliderPosition.toFloat(),
//                                onValueChange = { sliderPosition = it.toInt() },
//                                valueRange = 1f..10f,
//                                steps = 10,
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(10.dp)
//                            )
//                            Row(
//                                modifier = Modifier.fillMaxWidth(),
//                                horizontalArrangement = Arrangement.SpaceEvenly
//                            ) {
//                                Text(text = "Քանակ: $sliderPosition")
//                                Text(text = "Գին: ${member.price.toInt() * sliderPosition} դր")
//                            }
//                        }
                        Row(
                            modifier = Modifier
                                .width(110.dp)
                                .height(30.dp)
                                .background(
                                    color = Color(0xFF228B22),
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            horizontalArrangement = Arrangement.Center
                        ){
                            IconButton(
                                onClick = {
                                    member.count--
                                    if (member.count < 1) member.count = 1
                                },
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(30.dp)
                            ) {
                                HorizontalDivider(
                                    modifier = Modifier
                                        .width(15.dp),
                                    thickness = 1.dp,
                                    color = Color.Black
                                )
                            }
                            VerticalDivider(
                                color = Color.Black
                            )
                            Text(
                                modifier = Modifier
                                    .width(30.dp),
                                text = member.count.toString()
                            )
                            VerticalDivider(
                                color = Color.Black
                            )
                            IconButton(
                                onClick = {
                                    member.count++
                                },
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(30.dp)
                            ) {
                                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductPreview() {
    Product(
        member = Member(
            image = painterResource(id = R.drawable.userimg),
            name = "name",
            price = "1000")
    )
}
