package dev.rustybite.rustysport.presentation.league_fixture_screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rustybite.rustysport.data.dto.fixture.toFixtureResponse
import dev.rustybite.rustysport.data.repository.LeagueFixtureRepository
import dev.rustybite.rustysport.utils.RustySportsConstants.TAG
import dev.rustybite.rustysport.utils.RustySportsEvents
import dev.rustybite.rustysport.utils.RustySportsState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class LeagueFixtureViewModel @Inject constructor(
    private val repository: LeagueFixtureRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LeagueFixtureUiState())
    val uiState = _uiState.asStateFlow()
    private val _appEvents = Channel<RustySportsEvents>()
    val appEvents = _appEvents.receiveAsFlow()

    init {
        viewModelScope.launch {
            repository.getLeagueFixture(2023, 39).collectLatest { state ->
                when(state) {
                    is RustySportsState.Success -> {
                        val fixtures = state.data.response.map { fixtureResponseDto ->
                            fixtureResponseDto.toFixtureResponse()
                        }.filter { fixtureResponse ->
                            fixtureResponse.fixture.status.long != "Match Finished"
                                    &&fixtureResponse.fixture.status.long != "Match Postponed"
                                    &&fixtureResponse.fixture.status.long != "Second Half"
                                    &&fixtureResponse.fixture.status.long != "First Half"
                        }.sortedBy { fixtureResponse -> fixtureResponse.fixture.date }
                        fixtures.forEach { fixtureResponse ->
                            _uiState.value = _uiState.value.copy(
                                leagueName = fixtureResponse.league.name,
                                leagueLogo = fixtureResponse.league.logo
                            )
                        }
                        _uiState.value = _uiState.value.copy(
                            fixtures = fixtures,
                            loading = false
                        )
                        Log.d(TAG, "$fixtures")
                    }
                    is RustySportsState.Failure -> {
                        _uiState.value = _uiState.value.copy(
                            errorMessage = state.message,
                            loading = false
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

    fun onFixtureClicked(route: String) {
        viewModelScope.launch {
            _appEvents.send(RustySportsEvents.Navigate(route))
        }
    }

    fun onBackButtonClicked() {
        viewModelScope.launch {
            _appEvents.send(RustySportsEvents.ShowSnackBar("Popping back feature to be implemented"))
        }
    }

    fun onLeagueIconClicked() {
        viewModelScope.launch {
            _appEvents.send(RustySportsEvents.ShowSnackBar("This feature to be implemented"))
        }
    }

}