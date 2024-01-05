package dev.rustybite.rustysport.presentation.league_table_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rustybite.rustysport.data.dto.table.toLeague
import dev.rustybite.rustysport.data.dto.table.toStanding
import dev.rustybite.rustysport.data.dto.table.toTable
import dev.rustybite.rustysport.data.repository.LeagueTableRepository
import dev.rustybite.rustysport.domain.model.Standing
import dev.rustybite.rustysport.utils.RustySportsConstants.TAG
import dev.rustybite.rustysport.utils.RustySportsEvents
import dev.rustybite.rustysport.utils.RustySportsState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueTableViewModel @Inject constructor(
    private val repository: LeagueTableRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LeagueTableUiState())
    val uiState = _uiState.asStateFlow()
    private val _appEvent = Channel<RustySportsEvents>()
    val appEvent = _appEvent.receiveAsFlow()

    init {
        viewModelScope.launch {
            repository.getLeagueTable(2023, 39).collectLatest { state ->
                when (state) {
                    is RustySportsState.Success -> {
                        var standing = emptyList<Standing>()
                        state.data.toTable().response.forEach {
                            it.league.toLeague().standings.forEach {
                                standing = it.map { it.toStanding() }
                            }
                        }

                        _uiState.value = _uiState.value.copy(
                            standing = standing
                        )
                        Log.d(TAG, "league table: $standing")
                    }
                    is RustySportsState.Failure -> {
                        _uiState.value = _uiState.value.copy(
                            errorMessage = state.message
                        )
                    }
                    is RustySportsState.Loading -> {
                        _uiState.value = _uiState.value.copy(
                            loading = true
                        )
                    }

                }
            }
        }
    }

    fun onTeamClicked(route: String) {
        viewModelScope.launch {
            _appEvent.send(RustySportsEvents.Navigate(route))
        }
    }
}