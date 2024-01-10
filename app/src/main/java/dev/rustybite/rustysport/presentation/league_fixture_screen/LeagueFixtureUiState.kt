package dev.rustybite.rustysport.presentation.league_fixture_screen

import dev.rustybite.rustysport.domain.model.Fixture
import dev.rustybite.rustysport.domain.model.FixtureResponse

data class LeagueFixtureUiState(
    val loading: Boolean = false,
    val fixtures: List<FixtureResponse> = emptyList(),
    val leagueName: String = "",
    val leagueLogo: String = "",
    val errorMessage: String? = null
)
