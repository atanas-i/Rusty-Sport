package dev.rustybite.rustysport.presentation.league_table_screen

import dev.rustybite.rustysport.domain.model.Standing
import dev.rustybite.rustysport.domain.model.Table

data class LeagueTableUiState(
    val loading: Boolean = false,
    val standing: List<Standing> = emptyList(),
    val leagueName: String = "",
    val leagueLogo: String = "",
    val errorMessage: String? = null
)
