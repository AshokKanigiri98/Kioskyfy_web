package landingpage.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose_example.composeapp.generated.resources.Res
import compose_example.composeapp.generated.resources.app_development
import compose_example.composeapp.generated.resources.kiosk_adv_1
import compose_example.composeapp.generated.resources.kiosk_adv_brand_promotion
import compose_example.composeapp.generated.resources.kiosk_marketting_adv
import compose_example.composeapp.generated.resources.software_development
import compose_example.composeapp.generated.resources.web_development
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import utils.ImageComponent
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
    Text(
        text = "Our Products",
        color = Color.White,
        fontSize = 30.sp,
        modifier = Modifier.addBorder().padding(vertical = 5.dp, horizontal = 15.dp)
    )
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
                description = "Allow customers to complete tasks independently without staff assistance"
            )
        }

        item {
            BodyItem(
                title = "Digital Store Boards",
                description = "Display What's in your store on a digital screen",
                drawablePath = "drawable/kiosk_marketting_adv.webp"
            )
        }

        item {
            BodyItem(
                title = "Interactive Marketing Kiosks",
                description = "Let users interact with brand campaigns",
                drawablePath = "drawable/kiosk_adv_brand_promotion.webp"
            )
        }

        item {
            BodyItem(
                title = "Mobile App Development",
                description = "Custom mobile applications tailored to your business needs & with Kiosk Integration",
                drawablePath = "drawable/app_development.webp"
            )
        }

        item {
            BodyItem(
                title = "Web & Desktop Applications",
                description = "From idea to launch — web & desktop applications crafted just for your business",
                drawablePath = "drawable/web_development.webp"
            )
        }

        item {
            BodyItem(
                title = "And More ",
                description = "Beyond kiosks — we craft custom software solutions that scale with your business",
                drawablePath = "drawable/software_development.jpg"
            )
        }
    }
}

@Composable
private fun BodyItem(
    drawablePath: String,
    title: String,
    description: String,
) {
    Box(
        modifier = Modifier
            .size(height = 350.dp, width = 500.dp)
            .addBorder(color = Color.DarkGray)

    ) {
        ImageComponent(drawablePath = drawablePath, alpha = 0.25f)

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(25.dp)
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 26.sp
            )
            Text(
                text = description,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}
