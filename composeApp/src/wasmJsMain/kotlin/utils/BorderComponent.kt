package utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun Modifier.addBorder(
    color: Color = Color.DarkGray,
    width: Dp = 1.dp,
    cornerRadius: Dp = 8.dp
): Modifier = this.then(
    border(
        width = width,
        color = color,
        shape = RoundedCornerShape(cornerRadius)
    )
)