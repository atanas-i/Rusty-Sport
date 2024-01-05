package dev.rustybite.rustysport.presentation.league_table_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.rustybite.rustysport.utils.RustySportsEvents
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

    LaunchedEffect(key1 = appEvents) {
        appEvents.collectLatest { event ->
            when(event) {
                is RustySportsEvents.Navigate -> onNavigate(event)
                is RustySportsEvents.PopBackStack -> onPopBackStack(event)
                is RustySportsEvents.ShowSnackBar -> Unit
                is RustySportsEvents.ShowToast -> Unit
                else -> Unit
            }
        }
    }

    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            LeagueTableContent(
                onTeamClicked = viewModel::onTeamClicked,
                uiState = uiState,
                modifier = modifier
            )
        }
    }
}