package landingpage

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import utils.isMobile

@Composable
fun LandingScreen() {
    val viewModel: LandingViewModel = koinInject()
    val state = viewModel.uiState.collectAsState()
    LandingScreenComponent(state = state.value)
}

@Composable
private fun LandingScreenComponent(state: LandingPageUiState) {
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        state = listState,
        flingBehavior = ScrollableDefaults.flingBehavior(),
        userScrollEnabled = true
    ) {
        item(key = 1) {
            HomePage(homePage = state.homePage, isMobile())
        }

        item(key = 2)  {
            Spacer(modifier = Modifier.height(if(isMobile()) 30.dp else 20.dp))
        }

        item(key = 3)  {
            HeaderComponent(modifier = Modifier.background(color = Color.Black))
        }

        item(key = 4)  {
            Spacer(modifier = Modifier.height(if(isMobile()) 20.dp else 15.dp))
        }

        items(state.productsPage, key = { it.title }) { product ->
            ProductShowCaseScreen(product)
        }

        item(key = 5)  {
            Spacer(modifier = Modifier.height(20.dp))
        }

        item(key = 6)  {
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