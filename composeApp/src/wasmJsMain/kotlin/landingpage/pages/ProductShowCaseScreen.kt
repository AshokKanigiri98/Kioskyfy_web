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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import animations.cinematicAnimation
import domain.models.ProductsPage
import utils.ImageComponent
import utils.PageTitleComponent
import utils.addBorder

@Composable
internal fun ProductShowCaseScreen(product: ProductsPage) {
    BodyItem(
        modifier = Modifier.background(color = Color.Black).padding(10.dp),
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
                modifier = Modifier.cinematicAnimation(animMillis + 100)
            )
            Text(
                text = description,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.cinematicAnimation(animMillis + 300)
            )
        }
    }
}
