package landingpage

import androidx.compose.runtime.Composable
import landingpage.pages.LandingPage1
import landingpage.pages.LandingPage2
import landingpage.pages.LandingPage3
import utils.WebPager

@Composable
fun LandingScreen() {
    WebPager(
        pages = listOf(
        { LandingPage1() },
        { LandingPage2() },
            { LandingPage3() },
    ))
}