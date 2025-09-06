package landingpage.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose_example.composeapp.generated.resources.Res
import compose_example.composeapp.generated.resources.logo_black
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun LandingPage1() {
    Column(modifier = Modifier.background(color = Color.Black).padding(30.dp)) {
        HeaderComponent()
        BodyComponent()

    }
}

@Composable
private fun HeaderComponent() {
    Image(
        painterResource(Res.drawable.logo_black),
        contentDescription = "Kotlin Logo",
        modifier = Modifier.size(height = 450.dp, width = 800.dp)
    )
}

@Composable
private fun BodyComponent() {
    Surface(
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp), // only top rounded
        elevation = 15.dp,
        color = Color.Gray
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp) // inner padding
        ) {
            // Your content here
        }
    }
}