package landingpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

@Composable
fun FullPageScroller() {
    val colors = listOf(
        Color.Red, Color.Green, Color.Blue,
        Color.Cyan, Color.Magenta, Color.Yellow, Color.Gray
    )

    val viewportHeightPx = window.innerHeight
    val density = 1.0
    val viewportHeightDp = (viewportHeightPx / density).dp

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(colors) { index, color ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(viewportHeightDp)
                    .background(color)
            ) {
            }
        }
    }
}
