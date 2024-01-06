package dev.rustybite.rustysport.presentation.league_table_screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import dev.rustybite.rustysport.R

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
        item {
            Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.rs_padding_medium)))
            DescriptionItem(modifier = modifier)
        }
    }
}