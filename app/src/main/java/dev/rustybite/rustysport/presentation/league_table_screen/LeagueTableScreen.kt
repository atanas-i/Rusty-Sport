package dev.rustybite.rustysport.presentation.league_table_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.rustybite.rustysport.R
import dev.rustybite.rustysport.ui.components.RustySportsErrorBody
import dev.rustybite.rustysport.ui.components.RustySportsLoading
import dev.rustybite.rustysport.ui.components.RustySportsTopBar
import dev.rustybite.rustysport.utils.RustySportsEvents
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LeagueTableScreen(
    onNavigate: (RustySportsEvents.Navigate) -> Unit,
    onPopBackStack: (RustySportsEvents.PopBackStack) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LeagueTableViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value
    val appEvents = viewModel.appEvent
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = appEvents) {
        appEvents.collectLatest { event ->
            when (event) {
                is RustySportsEvents.Navigate -> onNavigate(event)
                is RustySportsEvents.PopBackStack -> onPopBackStack(event)
                is RustySportsEvents.ShowSnackBar -> {
                    snackbarHostState.showSnackbar(event.message)
                }

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
                navIconContentDescription = "Back Button",
                onNavigationIconClicked = viewModel::onBackButtonClicked,
                onLogoClocked = viewModel::onLogoClicked
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        modifier = modifier
    ) { paddingValues ->
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
                    LeagueTableContent(
                        onTeamClicked = viewModel::onTeamClicked,
                        uiState = uiState,
                        modifier = modifier
                    )
                }
            }
        }
    }
}