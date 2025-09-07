package landingpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import landingpage.pages.ContactUsScreen
import landingpage.pages.HomePage
import landingpage.pages.ProductShowCaseScreen
import landingpage.state.LandingPageUiState
import landingpage.viewmodel.LandingViewModel
import org.koin.compose.koinInject
import utils.PageTitleComponent

@Composable
fun LandingScreen() {
    val viewModel: LandingViewModel = koinInject()
    val state = viewModel.uiState.collectAsState()
    LandingScreenComponent(state = state.value)
}

@Composable
private fun LandingScreenComponent(state: LandingPageUiState) {
    LazyColumn(modifier = Modifier.fillMaxSize().background(color = Color.Black)) {
        item {
            HomePage(homePage = state.homePage)
        }
        item {
            HeaderComponent(modifier = Modifier.background(color = Color.Black))
        }

        items(state.productsPage) { product ->
            ProductShowCaseScreen(product)
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            ContactUsScreen(state.contactPage)
        }
    }
}

@Composable
private fun HeaderComponent(title: String = "Our Products & Services", modifier: Modifier) {
    PageTitleComponent(
        title = title,
        modifier = modifier.fillMaxWidth()
    )
}