import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RoundedCardPager() {
    val colors = listOf(
        Color.Red, Color.Green, Color.Blue,
        Color.Cyan, Color.Magenta, Color.Yellow, Color.Gray
    )

    val pagerState = rememberPagerState(pageCount = { colors.size })

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->

        val pageOffset = (
                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                ).absoluteValue

        Card(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    // 🔥 Animations
                    val scale = 1f - pageOffset * 0.2f
                    scaleX = scale
                    scaleY = scale
                    alpha = 1f - pageOffset * 0.4f
                    rotationZ = pageOffset * 15f
                },
            shape = RoundedCornerShape(32.dp), // ✅ rounded corners
            elevation = 8.dp // ✅ shadow
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors[page])
            )
        }
    }
}
