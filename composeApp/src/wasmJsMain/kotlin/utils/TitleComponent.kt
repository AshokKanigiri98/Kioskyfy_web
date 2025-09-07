package utils

import AppGradients
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import animations.cinematicAnimation

@Composable
fun PageTitleComponent(title: String) {
    Text(
        text = title,
        style = TextStyle(
            brush = AppGradients.goldGradient
        ),
        fontSize = 28.sp,
        modifier = Modifier
            .cinematicAnimation(500)
            .padding(vertical = 5.dp, horizontal = 15.dp)
    )
}