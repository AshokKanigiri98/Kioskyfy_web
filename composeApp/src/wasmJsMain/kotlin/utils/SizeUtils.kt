package utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

fun isMobile(): Boolean {
    return (window.innerWidth.dp < 1100.dp)
}

@Composable
fun getHeight(): Dp {
    val density = LocalDensity.current
    val width = with(density) { window.innerWidth.toDp() }
    val height = with(density) { window.innerHeight.toDp() }

    return if (width < 700.dp) {
        350.dp
    } else {
        height
    }
}

fun Modifier.safeSize() = this.then(
    if (isMobile()) size(
        height = 400.dp, width = window.outerWidth.dp
    )
    else fillMaxSize()
)