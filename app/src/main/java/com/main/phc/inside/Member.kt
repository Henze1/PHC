package com.main.phc.inside

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import java.util.UUID

data class Member(
    val image: Painter,
    val name: String,
    val price: String,
    val id: String = UUID.randomUUID().toString(),
    var producer: String = "",
    var producerCountry: String = "",
    var count: Int = 1,
    var icon: ImageVector = Icons.Default.FavoriteBorder,
    var isSelected: Boolean = false
)