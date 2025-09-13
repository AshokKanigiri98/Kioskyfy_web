package landingpage.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import animations.cinematicAnimation
import domain.models.HomePage
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import utils.ImageComponent
import utils.addBorder
import utils.safeSize

@Composable
internal fun HomePage(homePage: HomePage) {
    Column(
        modifier = Modifier.background(color = Color.Black)
            .safeSize()
            .padding(10.dp)
            .addBorder()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        HeaderComponent(logo = homePage.logo)
        BodyComponent(
            modifier = Modifier,
            backgroundImage = homePage.imageRes,
            title = homePage.title,
            description = homePage.description
        )

    }
}

@Composable
private fun HeaderComponent(logo: DrawableResource) {
    Image(
        painterResource(logo),
        contentDescription = "Kotlin Logo",
        modifier = Modifier
            .size(height = 100.dp, width = 300.dp)
            .cinematicAnimation(800)
    )
}

@Composable
private fun BodyComponent(
    modifier: Modifier,
    backgroundImage: String,
    title: String,
    description: String,
) {
    Box(modifier = modifier.background(color = Color.Black), contentAlignment = Alignment.Center) {

        ImageComponent(
            drawablePath = backgroundImage,
            alpha = 0.2f,
            modifier = Modifier.cinematicAnimation(200)
        )

        Box (contentAlignment = Alignment.Center){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center, // centers vertically
                horizontalAlignment = Alignment.CenterHorizontally // centers horizontally
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 26.sp,
                    modifier = Modifier.cinematicAnimation(400)
                )

                Spacer(Modifier.height(15.dp))

                Text(
                    text = description,
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.cinematicAnimation(1000)
                )
            }
        }
    }
}
