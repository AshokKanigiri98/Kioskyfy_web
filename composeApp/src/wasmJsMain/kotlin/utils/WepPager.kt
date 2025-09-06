package utils

import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WebPager(
    modifier: Modifier = Modifier,
    pages: List<@Composable () -> Unit>
) {
    val pagerState = rememberPagerState(pageCount = { pages.size })

    VerticalPager(
        state = pagerState,
        modifier = modifier
    ) { page ->
        pages.getOrNull(page)?.invoke()
    }
}