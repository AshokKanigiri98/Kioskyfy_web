package di

import domain.GetAllProductsUseCase
import domain.GetContactUsUseCase
import domain.GetHomePageUseCase
import domain.GetLandingPageDataUseCase
import landingpage.viewmodel.LandingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::LandingViewModel)
    single { GetHomePageUseCase() }
    single { GetAllProductsUseCase() }
    single { GetContactUsUseCase() }
    single {
        GetLandingPageDataUseCase(
            getHomePageUseCase = get(),
            getAllProductsUseCase = get(),
            getContactUsUseCase = get()
        )
    }
}