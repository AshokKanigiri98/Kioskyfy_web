package domain

import compose_example.composeapp.generated.resources.Res
import compose_example.composeapp.generated.resources.logo_black
import domain.models.ContactUsPage
import domain.models.HomePage
import domain.models.LandingPageModel
import domain.models.ProductsPage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow

class GetLandingPageDataUseCase(
    private val getHomePageUseCase: GetHomePageUseCase,
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val getContactUsUseCase: GetContactUsUseCase,
) {
    operator fun invoke(): Flow<LandingPageModel> {
        val homePage = getHomePageUseCase()
        val allProducts = getAllProductsUseCase()
        val contactUs = getContactUsUseCase()
        return combine(homePage, allProducts, contactUs) { home, products, contact ->
            LandingPageModel(
                homePage = home,
                productsPage = products,
                contactPage = contact
            )
        }
    }
}

class GetHomePageUseCase {
    operator fun invoke(): Flow<HomePage> {
        return flow {
            emit(
                HomePage(
                    logo = Res.drawable.logo_black,
                    title = "From storefront boards to interactive kiosks",
                    description = "We transform your business journey into a seamless digital experience",
                    imageRes = "drawable/kiosk_retro.png"
                )
            )
        }
    }
}

class GetAllProductsUseCase {
    operator fun invoke(): Flow<List<ProductsPage>> {
        return flow {
            emit(
                listOf(
                    ProductsPage(
                        title = "Self-Service Kiosks",
                        description = "Allow customers to complete tasks independently without staff assistance",
                        imageRes = "drawable/kiosk_adv_1.webp",
                        animMillis = 200
                    ),
                    ProductsPage(
                        title = "Digital Store Boards",
                        description = "Display What's in your store on a digital screen",
                        imageRes = "drawable/kiosk_marketting_adv.webp",
                        animMillis = 200
                    ),
                    ProductsPage(
                        title = "Interactive Marketing Kiosks",
                        description = "Let users interact with brand campaigns",
                        imageRes = "drawable/kiosk_adv_brand_promotion.webp",
                        animMillis = 200
                    ),
                    ProductsPage(
                        title = "Mobile App Development",
                        description = "Custom mobile applications tailored to your business needs & with Kiosk Integration",
                        imageRes = "drawable/app_development.jpg",
                        animMillis = 200,
                    ),
                    ProductsPage(
                        title = "Web & Desktop Applications",
                        description = "From idea to launch — web & desktop applications crafted just for your business",
                        imageRes = "drawable/web_development.jpg",
                        animMillis = 200
                    ),
                    ProductsPage(
                        title = "And More",
                        description = "Beyond kiosks — we craft custom software solutions that scale with your business",
                        imageRes = "drawable/software_development.jpg",
                        animMillis = 200
                    )
                )
            )
        }
    }
}

class GetContactUsUseCase {
    operator fun invoke(): Flow<ContactUsPage> {
        return flow {
            emit(
                ContactUsPage(
                    title = "Loading ...",
                    description = "Our new website is on the way — we’ll be live soon!",
                    imageRes = "drawable/kiosk_retro.png"
                )
            )
        }
    }
}