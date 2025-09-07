import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import di.appModule
import org.koin.core.context.GlobalContext.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        modules(appModule)
    }
    CanvasBasedWindow(canvasElementId = "ComposeTarget") { WebApp() }
}