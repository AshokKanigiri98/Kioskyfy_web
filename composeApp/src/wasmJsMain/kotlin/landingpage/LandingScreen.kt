import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import kotlinx.coroutines.launch

@Composable
fun FullPageScroller() {
    val colors = listOf(
        Color.Red, Color.Green, Color.Blue,
        Color.Cyan, Color.Magenta, Color.Yellow, Color.Gray
    )

    val viewportHeightPx = window.innerHeight
    val viewportHeightDp = viewportHeightPx.dp

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    // Detect when scrolling stops, then snap
    LaunchedEffect(listState.isScrollInProgress) {
        if (!listState.isScrollInProgress) {
            val firstVisible = listState.firstVisibleItemIndex
            val offset = listState.firstVisibleItemScrollOffset

            val targetIndex = if (offset > viewportHeightPx / 2) {
                firstVisible + 1
            } else {
                firstVisible
            }

            scope.launch {
                listState.animateScrollToItem(targetIndex)
            }
        }
    }

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(colors) { _, color ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(viewportHeightDp)
                    .background(color)
            )
        }
    }
}
