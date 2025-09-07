package domain.models

import compose_example.composeapp.generated.resources.Res
import compose_example.composeapp.generated.resources.logo_black
import org.jetbrains.compose.resources.DrawableResource

data class LandingPageModel(
    val homePage: HomePage = HomePage(),
    val productsPage: List<ProductsPage> = emptyList(),
    val contactPage: ContactUsPage = ContactUsPage(),
)

data class HomePage(
    val logo: DrawableResource = Res.drawable.logo_black,
    val title: String = "",
    val description: String = "",
    val imageRes: String = "",
)

data class ProductsPage(
    val title: String = "",
    val description: String = "",
    val imageRes: String = "",
    val animMillis: Int,
)

data class ContactUsPage(
    val title: String = "",
    val description: String = "",
    val imageRes: String = "",
)