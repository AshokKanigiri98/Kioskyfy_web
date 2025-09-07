package landingpage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.GetLandingPageDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import landingpage.state.LandingPageUiState

class LandingViewModel(private val getLandingPageDataUseCase: GetLandingPageDataUseCase) :
    ViewModel() {
    private val _uiState = MutableStateFlow(LandingPageUiState.STATE)
    val uiState: StateFlow<LandingPageUiState> get() = _uiState

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.Default) {
            getLandingPageDataUseCase()
                .collectLatest { data ->
                    _uiState.update { state ->
                        state.copy(
                            homePage = data.homePage,
                            productsPage = data.productsPage,
                            contactPage = data.contactPage
                        )
                    }
                }
        }
    }
}