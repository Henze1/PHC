package com.main.phc

import  android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.main.phc.inside.Member
import com.main.phc.inside.Product
import com.main.phc.ui.theme.PHCTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PHCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    AppNavGraph()
                    val list1 = ArrayList<Member>()
                    val list2 = SnapshotStateList<Member>()

                    val member = Member(
                        image = painterResource(id = R.drawable.userimg),
                        name = "A product with a long name",
                        price = "7980",
                        producer = "Producer",
                        producerCountry = "Country",
                        id = "123456789"
                    )
                    Product(member, list1, list2)
                }
            }
        }
    }
}