package landingpage.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose_example.composeapp.generated.resources.Res
import compose_example.composeapp.generated.resources.logo_black
import org.jetbrains.compose.resources.painterResource
import utils.ImageComponent

@Composable
internal fun LandingPage1() {
    Column(
        modifier = Modifier.background(color = Color.Black).padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        HeaderComponent()
        BodyComponent(modifier = Modifier.fillMaxSize())

    }
}

@Composable
private fun HeaderComponent() {
    Image(
        painterResource(Res.drawable.logo_black),
        contentDescription = "Kotlin Logo",
        modifier = Modifier.size(height = 100.dp, width = 300.dp)
    )
}

@Composable
private fun BodyComponent(modifier: Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp), // only top rounded
        elevation = 15.dp,
        color = Color.Black
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            ImageComponent(drawablePath = "drawable/kiosk_retro.webp", alpha = 0.2f)

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "From storefront boards to interactive kiosks",
                        color = Color.White,
                        fontSize = 26.sp
                    )

                    Text(
                        text = "We transform your business journey into a seamless digital experience",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}