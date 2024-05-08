package com.main.phc.inside

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.phc.R
import com.main.phc.ui.theme.loadImageFromUrl
import java.util.UUID

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Vitamins() {
    val memberImagesLinks: List<String> = listOf(
        "https://scontent.fevn4-2.fna.fbcdn.net/v/t39.30808-6/295751195_425161516327682_6584328865171916036_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_ohc=SqLgUUkVSi4Q7kNvgFTbi-x&_nc_ht=scontent.fevn4-2.fna&oh=00_AfCDfoOHuUUu3hQ7IiWAt61EhooY16bK139PBfQAiSJDSQ&oe=66417DE3",
        "https://qph.cf2.quoracdn.net/main-qimg-2ca1a453176bbf8cd0bb9e5af8820f62-lq",
        "https://qph.cf2.quoracdn.net/main-qimg-1e73c8061a21dc9d0d35b2dbf630075f-lq",
        "https://myhotposters.com/cdn/shop/products/mC0058_1024x1024.jpeg?v=1571444022",
        "https://pbs.twimg.com/media/EFHpUoDUUAAhFQe.jpg",
        "https://www.mother.ly/wp-content/uploads/2021/10/origin-6643-scaled.jpg",
        "https://assets.gqindia.com/photos/5cdc58fae994c8b0f9b6864e/16:9/w_2560%2Cc_limit/Emily-Ratajkowski-hot-photos-top-image.jpg",
        "https://i5.walmartimages.com/asr/e706299b-cb14-4f3d-ad0c-f82138452581.7e6f22ca9ba474a2b83259fcbb2919d7.jpeg?odnHeight=768&odnWidth=768&odnBg=FFFFFF",
        "https://i.ebayimg.com/images/g/liEAAOSw1aFgvuZt/s-l1200.webp",
        "https://www.gympaws.com/wp-content/uploads/2020/01/How-Jen-Got-Jacked-At-Gym-400x340.jpg",
        "https://i.pinimg.com/474x/2d/db/76/2ddb76c3c569f0973f1df717da56a231.jpg",
        "https://i.pinimg.com/736x/29/65/fa/2965faec6f7751ef4dacee8df0bbe8f4.jpg")

    val memberForRawImages: ArrayList<Member> = ArrayList()
    memberImagesLinks.forEach {
        memberForRawImages.add(Member(loadImageFromUrl(it)))
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

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize(),
            columns = GridCells.Fixed(2),
            content = {
                items(
                    key = {
                        memberForRawImages[it].id
                    },
                    count =  memberForRawImages.size
                ) {index ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.Transparent),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(painter = memberForRawImages[index].image, contentDescription = null)
                    }
                }
            }
        )
    }
}

data class Member(
    val image: Painter,
    val id: String = UUID.randomUUID().toString()
)
@Preview(showBackground = true)
@Composable
fun VitaminsPreview() {
    Vitamins()
}