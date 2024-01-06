package dev.rustybite.rustysport.presentation.league_table_screen

import dev.rustybite.rustysport.domain.model.Fixture

data class LeagueFixtureUiState(
    val loading: Boolean = false,
    val fixtures: List<Fixture> = emptyList(),
    val leagueName: String = "",
    val leagueLogo: String = "",
    val errorMessage: String? = null
)
