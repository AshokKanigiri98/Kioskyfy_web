package landingpage

import WebLazyColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import landingpage.pages.LandingPage1
import landingpage.pages.LandingPage2
import landingpage.pages.LandingPage3
import landingpage.pages.LandingPage4
import webItem

@Composable
fun LandingScreen() {
    WebLazyColumn {
        webItem {
            LandingPage1()
        }
        webItem {
            LandingPage2()
        }
        webItem {
            LandingPage1()
        }
        webItem {
            LandingPage1()
        }
    }
}