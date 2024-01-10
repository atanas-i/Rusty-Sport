package dev.rustybite.rustysport.presentation.league_fixture_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.rustybite.rustysport.presentation.ui.components.RustySportsStickyHeader

@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LeagueFixtureContent(
    uiState: LeagueFixtureUiState,
    onFixtureClicked: (String) -> Unit,
    modifier: Modifier
) {
    val groupedFixture = uiState.fixtures.groupBy { it.fixture.date }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        groupedFixture.forEach { (date, fixtures) ->
            stickyHeader(date) {
                val formattedDate = "${date.dayOfMonth} ${date.month.name} ${date.year}"
                RustySportsStickyHeader(
                    headerTitle = formattedDate,
                    modifier = modifier
                )
            }
                items(fixtures) { fixture ->
                    LeagueFixtureItem(
                        fixture = fixture,
                        onFixtureClicked = onFixtureClicked,
                        modifier = modifier
                    )
                }
        }
    }
}