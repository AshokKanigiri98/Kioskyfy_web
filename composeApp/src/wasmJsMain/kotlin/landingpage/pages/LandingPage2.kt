package landingpage.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import animations.cinematicAnimation
import utils.ImageComponent
import utils.PageTitleComponent
import utils.addBorder

@Composable
internal fun LandingPage2() {
    Column(
        modifier = Modifier.background(color = Color.Black).padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        HeaderComponent()
        BodyComponent(modifier = Modifier.fillMaxSize())

    }
}

@Composable
private fun HeaderComponent() {
    PageTitleComponent("Our Products & Services")
}

@Composable
private fun BodyComponent(modifier: Modifier) {
    LazyVerticalGrid(
        GridCells.Fixed(3), modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        item {
            BodyItem(
                drawablePath = "drawable/kiosk_adv_1.webp",
                title = "Self-Service Kiosks",
                description = "Allow customers to complete tasks independently without staff assistance",
                animMillis = 500
            )
        }

        item {
            BodyItem(
                title = "Digital Store Boards",
                description = "Display What's in your store on a digital screen",
                drawablePath = "drawable/kiosk_marketting_adv.webp",
                animMillis = 1000
            )
        }

        item {
            BodyItem(
                title = "Interactive Marketing Kiosks",
                description = "Let users interact with brand campaigns",
                drawablePath = "drawable/kiosk_adv_brand_promotion.webp",
                animMillis = 1500
            )
        }

        item {
            BodyItem(
                title = "Mobile App Development",
                description = "Custom mobile applications tailored to your business needs & with Kiosk Integration",
                drawablePath = "drawable/app_development.webp",
                animMillis = 2000
            )
        }

        item {
            BodyItem(
                title = "Web & Desktop Applications",
                description = "From idea to launch — web & desktop applications crafted just for your business",
                drawablePath = "drawable/web_development.webp",
                animMillis = 2500
            )
        }

        item {
            BodyItem(
                title = "And More ",
                description = "Beyond kiosks — we craft custom software solutions that scale with your business",
                drawablePath = "drawable/software_development.jpg",
                animMillis = 3000
            )
        }
    }
}

@Composable
private fun BodyItem(
    drawablePath: String,
    title: String,
    description: String,
    animMillis: Int,
) {
    Box(
        modifier = Modifier
            .cinematicAnimation(animMillis)
            .size(height = 350.dp, width = 500.dp)
            .addBorder(color = Color.DarkGray)


    ) {
        ImageComponent(drawablePath = drawablePath, alpha = 0.2f)

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(25.dp)
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 26.sp,
                modifier = Modifier.cinematicAnimation(animMillis + 600)
            )
            Text(
                text = description,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.cinematicAnimation(animMillis + 1000)
            )
        }
    }
}
