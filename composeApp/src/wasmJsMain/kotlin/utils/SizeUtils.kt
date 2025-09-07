package utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

@Composable
fun getHeight(): Dp {
    val density = LocalDensity.current
    val width = with(density) { window.innerWidth.toDp() }
    val height = with(density) { window.innerHeight.toDp() }

    return if (width < 800.dp) {
        350.dp
    } else {
        height
    }
}