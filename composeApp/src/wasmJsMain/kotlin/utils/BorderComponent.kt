package utils

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun Modifier.addBorder(
    color: Color = Color.DarkGray,
    width: Dp = 1.dp,
    cornerRadius: Dp = 8.dp,
): Modifier {
    val borderShape = RoundedCornerShape(cornerRadius )

    return this
        .clip(borderShape)
        .border(
            width = if (isMobile()) 0.dp else width,
            color = if (isMobile()) Color.Black else color,
            shape = borderShape
        )
}