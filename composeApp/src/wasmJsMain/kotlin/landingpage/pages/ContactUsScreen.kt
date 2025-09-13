package landingpage.pages

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
import domain.models.ContactUsPage
import kotlinx.browser.window
import utils.ImageComponent
import utils.PageTitleComponent
import utils.addBorder
import utils.getHeight
import utils.safeSize

@Composable
internal fun ContactUsScreen(contactUsPage: ContactUsPage) {
    Column(
        modifier = Modifier.background(color = Color.Black)
            .safeSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderComponent()
        BodyComponent(
            modifier = Modifier,
            backgroundRes = contactUsPage.imageRes,
            title = contactUsPage.title,
            description = contactUsPage.description
        )
    }
}

@Composable
private fun HeaderComponent() {
    PageTitleComponent("Contact us")
}

@Composable
private fun BodyComponent(
    modifier: Modifier,
    backgroundRes: String,
    title: String,
    description: String,
) {
    Box(
        modifier = modifier.background(color = Color.Black).padding(10.dp).addBorder(),
        contentAlignment = Alignment.Center
    ) {

        ImageComponent(
            drawablePath = backgroundRes,
            alpha = 0.2f,
            modifier = Modifier.cinematicAnimation(200)
        )

        Box(contentAlignment = Alignment.Center) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center, // centers vertically
                horizontalAlignment = Alignment.CenterHorizontally // centers horizontally
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 26.sp,
                    modifier = Modifier.cinematicAnimation(600)
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
