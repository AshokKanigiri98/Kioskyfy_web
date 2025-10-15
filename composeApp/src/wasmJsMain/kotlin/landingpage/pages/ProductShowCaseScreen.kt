package landingpage.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import animations.cinematicAnimation
import domain.models.ProductsPage
import utils.ImageComponent
import utils.addBorder
import utils.default_line_height
import utils.descriptionTextSize
import utils.headerTextSize
import utils.isMobile
import utils.tile_des_seperator_gap

@Composable
internal fun ProductShowCaseScreen(product: ProductsPage) {
    BodyItem(
        modifier = Modifier.background(color = Color.Black)
            .padding(if (isMobile()) 5.dp else 10.dp),
        drawablePath = product.imageRes,
        title = product.title,
        description = product.description,
        animMillis = product.animMillis
    )
}


@Composable
private fun BodyItem(
    modifier: Modifier,
    drawablePath: String,
    title: String,
    description: String,
    animMillis: Int,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .cinematicAnimation(animMillis)
            .size(height = 350.dp, width = 500.dp)
            .addBorder(color = Color.DarkGray)


    ) {
        ImageComponent(
            drawablePath = drawablePath,
            alpha = if (isMobile()) 0.35f else 0.2f,
        )

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(tile_des_seperator_gap.dp),
            modifier = Modifier.padding(25.dp)
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = headerTextSize(),
                style = TextStyle(lineHeight = default_line_height),
                modifier = Modifier.cinematicAnimation(animMillis + 100)
            )
            Text(
                text = description,
                color = Color.White,
                fontSize = descriptionTextSize(),
                style = TextStyle(lineHeight = default_line_height),
                modifier = Modifier.cinematicAnimation(animMillis + 300)
            )
        }
    }
}
