package dev.rustybite.rustysport.presentation.league_fixture_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.rustybite.rustysport.R
import dev.rustybite.rustysport.domain.model.FixtureResponse

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LeagueFixtureItem(
    fixture: FixtureResponse,
    onFixtureClicked: (String) -> Unit,
    modifier: Modifier
) {
    val cardColors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(.2f),
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onFixtureClicked("fixture_details/${fixture.fixture.id}") },
        colors = cardColors,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.rs_card_shape_no_shape)),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = fixture.fixture.time.toString(),
                style = MaterialTheme.typography.labelLarge,
            )
            Column(
                modifier = modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(
                            context = LocalContext.current
                        )
                            .data(fixture.teams.home.logo)
                            .build(),
                        contentDescription = "${fixture.teams.home.name} logo",
                        modifier = modifier
                            .size(dimensionResource(id = R.dimen.rs_team_logo_size_medium))
                    )
                    Text(
                        text = fixture.teams.home.name,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(
                            context = LocalContext.current
                        )
                            .data(fixture.teams.away.logo)
                            .build(),
                        contentDescription = "${fixture.teams.away.name} logo",
                        modifier = modifier
                            .size(dimensionResource(id = R.dimen.rs_team_logo_size_medium))
                    )
                    Text(
                        text = fixture.teams.away.name,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Text(
                text = fixture.fixture.date.dayOfWeek.name.take(3),
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}