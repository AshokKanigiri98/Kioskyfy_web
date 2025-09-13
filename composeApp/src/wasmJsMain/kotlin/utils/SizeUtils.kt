package utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

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
    if (window.innerWidth.dp > 600.dp) fillMaxSize()
    else size(
        height = 350.dp, width = window.innerWidth.dp
    )
)