package utils

import AppGradients
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import animations.cinematicAnimation

@Composable
fun PageTitleComponent(title: String, modifier: Modifier = Modifier.fillMaxWidth()) {
    Text(
        text = title,
        style = TextStyle(
            brush = AppGradients.goldGradient
        ),
        textAlign = TextAlign.Center,
        fontSize = 28.sp,
        modifier = modifier
            .cinematicAnimation(500)
    )
}