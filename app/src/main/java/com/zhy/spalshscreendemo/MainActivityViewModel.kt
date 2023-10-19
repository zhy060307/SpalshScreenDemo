package com.zhy.spalshscreendemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<InitState> =
        MutableStateFlow(InitState.Loading)

    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(5000)
            _uiState.update { InitState.Success("InitOk") }
        }
    }
}


sealed interface InitState {
    data object Loading : InitState
    data class Success(val userData: String) : InitState
}