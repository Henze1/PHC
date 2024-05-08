package com.main.phc.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.RoundedCornersTransformation

@Composable
fun loadImageFromUrl(url: String): Painter {
    val painter: Painter = rememberImagePainter(
        data = url,
        builder = {
            // You can add transformations here if needed
            transformations(RoundedCornersTransformation())
            scale(Scale.FILL)
        }
    )

    return painter
}