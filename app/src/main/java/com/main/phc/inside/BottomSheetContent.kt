package com.main.phc.inside

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.phc.viewmodels.MemberViewModel.Companion.memberList

@Composable
fun SheetContent() {
    val items = memberList

    val price = items.sumOf { it.price.replace("_դր", "").toInt() * it.count }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            text = "Ընդհանուր։ $price դր",
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 10.dp)
        )
        Button(
            modifier = Modifier
                .padding(6.dp),
            onClick = {
                // TODO("Buy")
            }
        ) {
            Text(text = "Պատվիրել")
        }
    }

    HorizontalDivider(
        thickness = 1.dp,
        color = Color.Gray
    )
    Spacer(modifier = Modifier.height(6.dp))
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        if (items.isEmpty()) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Այս դաշտը դատարկ է")
                }
            }
        } else {
            items(
                key = { items[it].id },
                count = items.size
            ) { index ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                        ) {
                            Image(
                                painter = items[index].image,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                            Text(
                                text = items[index].count.toString(),
                                color = Color.Black,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .background(Color.White, shape = CircleShape)
                                    .padding(4.dp)
                            )
                        }
                        Column {
                            Text(
                                text = items[index].name.replace('_', ' '),
                                color = Color.Black,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                            Text(text = items[index].price.replace('_', ' '))
                        }
                    }
                    IconButton(
                        onClick = {
                            // TODO("Remove from cart")
                            items.removeAt(index)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SheetContentPreview() {
    SheetContent()
}
