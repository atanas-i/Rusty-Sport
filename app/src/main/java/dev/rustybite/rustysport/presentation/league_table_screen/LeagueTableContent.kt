package dev.rustybite.rustysport.presentation.league_table_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LeagueTableContent(
    onTeamClicked: (String) -> Unit,
    uiState: LeagueTableUiState,
    modifier: Modifier
) {
    LazyColumn() {
        item { LeagueTableHeaderItem(modifier = modifier) }
        items(uiState.standing) { standing ->
            LeagueTableItem(
                onTeamClicked = onTeamClicked,
                standing = standing,
                modifier = modifier
            )
        }
    }
}