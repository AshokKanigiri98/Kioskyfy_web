
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import landingpage.FullPageScroller
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun WebApp() {
    MaterialTheme {
        FullPageScroller()
    }
}