package com.shriram.fashionapp.customComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun CustomShapeImage_T(painter: Painter) {
    val density = LocalDensity.current

    val TShape: Shape = GenericShape { size, _ ->
        val offset = with(density) { 80.dp.toPx() }
        moveTo(0f, 0f)
        lineTo(size.width, 0f)
        lineTo(size.width, size.height / 2)
        lineTo(size.width / 2 + offset, size.height / 2)
        lineTo(size.width / 2 + offset, size.height)
        lineTo(size.width / 2 - offset, size.height)
        lineTo(size.width / 2 - offset, size.height / 2)
        lineTo(0f, size.height / 2)
        close()
    }

    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(380.dp)
            .clip(TShape)
            .scale(1.1f),
        alignment = Alignment.Center
    )
}
