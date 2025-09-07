package utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
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

    AsyncImage(
        model = Res.getUri(drawablePath),
        contentDescription =  null,
        modifier = modifier.fillMaxSize().alpha(if (loaded) alpha else 0f),
        contentScale = contentScale,
        onSuccess = { loaded = true }
    )
}