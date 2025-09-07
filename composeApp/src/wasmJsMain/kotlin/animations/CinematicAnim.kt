package animations

import androidx.compose.ui.composed

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import kotlinx.coroutines.delay

/**
 * Applies a cinematic entrance animation to any Composable.
 * Fade-in, scale-up, and slide-from-bottom effect.
 *
 * @param delayMillis optional delay before the animation starts
 */
fun Modifier.cinematicAnimation(delayMillis: Int = 500): Modifier = composed {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (delayMillis > 0) delay(delayMillis.toLong())
        visible = true
    }

    val alphaAnim by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = spring(dampingRatio = 0.7f, stiffness = 300f)
    )

    val scaleAnim by animateFloatAsState(
        targetValue = if (visible) 1f else 0.9f,
        animationSpec = spring(dampingRatio = 0.6f, stiffness = 300f)
    )

    val translationY by animateFloatAsState(
        targetValue = if (visible) 0f else 30f,
        animationSpec = spring(dampingRatio = 0.7f, stiffness = 250f)
    )

    this.graphicsLayer {
        alpha = alphaAnim
        scaleX = scaleAnim
        scaleY = scaleAnim
        this.translationY = translationY
    }
}