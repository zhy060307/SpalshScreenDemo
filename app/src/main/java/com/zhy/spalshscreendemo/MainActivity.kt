package com.zhy.spalshscreendemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    private var showSplash = true
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.onEach {
                    showSplash = when (it) {
                        is InitState.Loading -> {
                            true
                        }

                        is InitState.Success -> {
                            false
                        }
                    }
                }.collect()
            }
        }
        splashScreen.setKeepOnScreenCondition { showSplash }
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

    }
}

