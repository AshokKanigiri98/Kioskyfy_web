import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

fun LazyListScope.webItem(
    itemHeightPx: Int = window.innerHeight,
    content: @Composable Modifier.() -> Unit
) {
    item {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeightPx.dp) // force full-screen height
        ) {
            content(Modifier.fillMaxSize())
        }
    }
}