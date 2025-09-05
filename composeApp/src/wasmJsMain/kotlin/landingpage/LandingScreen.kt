package landingpage

import BaseScrollComponent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import landingpage.pages.LandingPage1
import landingpage.pages.LandingPage2
import landingpage.pages.LandingPage3
import landingpage.pages.LandingPage4
import utils.addBorder

@Composable
fun LandingScreen() {
    BaseScrollComponent(
        pages = listOf(
            { LandingPage1() },
            { LandingPage2() },
            { LandingPage3() },
            { LandingPage4() })
    )
}