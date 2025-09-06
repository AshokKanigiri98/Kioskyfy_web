package animations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import kotlin.math.absoluteValue

fun Modifier.depthPageEffect(pageOffset: Float): Modifier = this.then(
    Modifier.graphicsLayer {
        val scale = 0.85f + (1f - pageOffset) * 0.15f
        scaleX = scale
        scaleY = scale
        alpha = 0.5f + (1f - pageOffset) * 0.5f
    }
)

@Composable
fun Modifier.fadePageEffect(pageOffset: Float): Modifier {
    // Animate alpha based on page offset (0 = fully visible, 1+ = invisible)
    val alpha by animateFloatAsState(
        targetValue = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f),
    )

    return this.graphicsLayer {
        this.alpha = alpha
    }
}