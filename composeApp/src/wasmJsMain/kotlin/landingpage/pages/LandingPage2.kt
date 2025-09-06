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
                backgroundImage = Res.drawable.kiosk_adv_1,
                title = "Self-Service Kiosks",
                description = "Allow customers to complete tasks independently without staff assistance"
            )
        }

        item {
            BodyItem(
                backgroundImage = Res.drawable.kiosk_marketting_adv,
                title = "Digital Store Boards",
                description = "Display What's in your store on a digital screen"
            )
        }

        item {
            BodyItem(
                backgroundImage = Res.drawable.kiosk_adv_brand_promotion,
                title = "Interactive Marketing Kiosks",
                description = "Let users interact with brand campaigns"
            )
        }

        item {
            BodyItem(
                backgroundImage = Res.drawable.app_development,
                title = "Mobile App Development",
                description = "Custom mobile applications tailored to your business needs & with Kiosk Integration"
            )
        }

        item {
            BodyItem(
                backgroundImage = Res.drawable.web_development,
                title = "Web & Desktop Applications",
                description = "From idea to launch — web & desktop applications crafted just for your business"
            )
        }

        item {
            BodyItem(
                backgroundImage = Res.drawable.software_development,
                title = "And More ",
                description = "Beyond kiosks — we craft custom software solutions that scale with your business"
            )
        }
    }
}

@Composable
private fun BodyItem(
    backgroundImage: DrawableResource,
    title: String,
    description: String,
) {
    val resource = remember { backgroundImage }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .addBorder(color = Color.DarkGray)

    ) {
        Image(
            modifier = Modifier.size(height = 400.dp, width = 500.dp).alpha(0.25f),
            painter = painterResource(resource),
            contentDescription = "Kiosk Retro",
            contentScale = ContentScale.Crop
        )

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
