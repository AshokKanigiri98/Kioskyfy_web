package utils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

fun getHeight(): Dp {
    val width = window.innerWidth.dp
    if (width < 700.dp) {
        return 350.dp
    }
    return window.innerHeight.dp
}