package landingpage.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import utils.ImageComponent
import utils.addBorder

@Composable
internal fun LandingPage3() {
    Column(
        modifier = Modifier.background(color = Color.Black).padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderComponent()
        BodyComponent(modifier = Modifier.fillMaxSize())

    }
}

@Composable
private fun HeaderComponent() {
   Text(text = "Contact Us",
       color = Color.White,
       fontSize = 30.sp,
       modifier = Modifier.addBorder().padding(horizontal = 25.dp, vertical = 5.dp)
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
        ImageComponent(drawablePath = "drawable/kiosk_retro.webp", alpha = 0.25f)

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
                        "Loading ...",
                        color = Color.White,
                        fontSize = 28.sp
                    )

                    Text(
                        text = "Our new website is on the way — we’ll be live soon!",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
