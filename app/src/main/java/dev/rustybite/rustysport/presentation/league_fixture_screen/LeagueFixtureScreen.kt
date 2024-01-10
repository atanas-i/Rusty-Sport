package dev.rustybite.rustysport.presentation.league_fixture_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.rustybite.rustysport.R
import dev.rustybite.rustysport.presentation.ui.components.RustySportsErrorBody
import dev.rustybite.rustysport.presentation.ui.components.RustySportsLoading
import dev.rustybite.rustysport.presentation.ui.components.RustySportsTopBar
import dev.rustybite.rustysport.utils.RustySportsEvents
import kotlinx.coroutines.flow.collectLatest

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LeagueFixtureScreen(
    onNavigate: (RustySportsEvents.Navigate) -> Unit,
    onPopBackStack: (RustySportsEvents.PopBackStack) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LeagueFixtureViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value
    val appEvents = viewModel.appEvents
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = appEvents) {
        appEvents.collectLatest { event ->
            when(event) {
                is RustySportsEvents.Navigate -> onNavigate(event)
                is RustySportsEvents.PopBackStack -> onPopBackStack(event)
                is RustySportsEvents.ShowSnackBar -> snackbarHostState.showSnackbar(event.message)
                is RustySportsEvents.ShowToast -> Unit
            }
        }
    }
    
    Scaffold(
        topBar = {
            RustySportsTopBar(
                title = uiState.leagueName,
                logoUrl = uiState.leagueLogo,
                navigationIcon = R.drawable.back_arrow_icon,
                navIconContentDescription = uiState.leagueName,
                onNavigationIconClicked = viewModel::onBackButtonClicked,
                onLogoClocked = viewModel::onLeagueIconClicked
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ){ paddingValues ->  
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (uiState.loading) {
                RustySportsLoading()
            } else {
                if (uiState.errorMessage != null) {
                    RustySportsErrorBody(message = uiState.errorMessage)
                } else {
                    LeagueFixtureContent(
                        uiState = uiState,
                        onFixtureClicked = viewModel::onFixtureClicked,
                        modifier = modifier
                    )
                }
            }
        }
    }
}