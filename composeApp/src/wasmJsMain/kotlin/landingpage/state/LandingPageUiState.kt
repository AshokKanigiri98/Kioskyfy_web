package landingpage.state

import domain.models.ContactUsPage
import domain.models.HomePage
import domain.models.ProductsPage

data class LandingPageUiState(
    val homePage: HomePage = HomePage(),
    val productsPage: List<ProductsPage> = emptyList(),
    val contactPage: ContactUsPage = ContactUsPage(),
) {

    companion object {
        val STATE = LandingPageUiState()
    }
}