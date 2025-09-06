import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import kotlinx.coroutines.launch

@Composable
fun WebLazyColumn(
    modifier: Modifier = Modifier.fillMaxSize(),
    itemHeightPx: Int = window.innerHeight,
    content: LazyListScope.() -> Unit
) {
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    // Snap effect
    LaunchedEffect(listState.isScrollInProgress) {
        if (!listState.isScrollInProgress) {
            val firstVisible = listState.firstVisibleItemIndex
            val offset = listState.firstVisibleItemScrollOffset

            val targetIndex = if (offset > itemHeightPx / 2) {
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
        modifier = modifier
    ) {
        content()
    }
}
