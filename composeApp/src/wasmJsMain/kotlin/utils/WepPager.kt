package utils

import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier

@Composable
fun WebPager(
    modifier: Modifier = Modifier,
    pages: List<@Composable () -> Unit>
) {
    val pagerState = rememberPagerState(pageCount = { pages.size })

    CompositionLocalProvider {
        VerticalPager(
            state = pagerState,
            modifier = modifier
        ) { page ->
            // Keep each composable stable with remember
            key(page) {
                pages[page].invoke()
            }
        }
    }
}