package utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import compose_example.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@Composable
fun ImageComponent(
    drawablePath: String,
    alpha: Float = 1f,
    contentScale: ContentScale = ContentScale.Crop,
    modifier: Modifier = Modifier
) {

    @OptIn(ExperimentalResourceApi::class)
    AsyncImage(
        model = Res.getUri(drawablePath),
        contentDescription =  null,
        modifier = modifier.fillMaxSize().alpha(alpha),
        contentScale = contentScale
    )
}