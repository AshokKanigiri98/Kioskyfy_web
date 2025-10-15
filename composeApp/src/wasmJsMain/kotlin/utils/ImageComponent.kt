package utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import compose_example.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ImageComponent(
    drawablePath: String,
    alpha: Float = 1f,
    contentScale: ContentScale = ContentScale.Crop,
    modifier: Modifier = Modifier
) {
    var loaded by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        // Image
        AsyncImage(
            model = drawablePath,
            contentDescription = null,
            contentScale = contentScale,
            modifier = Modifier.fillMaxSize().alpha(if (loaded) alpha else 0f),
            onSuccess = { loaded = true }
        )

        // Loader
        if (!loaded) {
            CircularProgressIndicator(
                color = Color.Gray,
                strokeWidth = 2.dp,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}