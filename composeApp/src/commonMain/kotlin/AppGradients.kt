import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object AppGradients  {

    val goldGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFb5882b), // deep golden brown (shadow)
            Color(0xFFe0b84d), // soft gold mid-tone
            Color(0xFFffd700), // highlight
            Color(0xFFe0b84d), // soft gold mid-tone
            Color(0xFFb5882b)  // deep golden brown (shadow)
        )
    )
}