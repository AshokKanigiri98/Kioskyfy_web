import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import animations.depthPageEffect
import animations.fadePageEffect
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BaseScrollComponent(
    pages: List<@Composable () -> Unit>,
    parentModifier: Modifier = Modifier.fillMaxSize(),
    childModifier: Modifier = Modifier.fillMaxSize(),
) {
    val pagerState = rememberPagerState(pageCount = { pages.size })

    VerticalPager(
        state = pagerState,
        modifier = parentModifier
    ) { page ->

        val pageOffset = (
                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                ).absoluteValue

        Card(
            modifier = childModifier
                .fadePageEffect(pageOffset),
            elevation = 8.dp
        ) {
            pages.getOrNull(page)?.invoke()
        }
    }
}
