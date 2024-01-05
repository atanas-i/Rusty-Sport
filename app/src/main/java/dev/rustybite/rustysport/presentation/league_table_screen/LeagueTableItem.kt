package dev.rustybite.rustysport.presentation.league_table_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.rustybite.rustysport.R
import dev.rustybite.rustysport.domain.model.Standing

@Composable
fun LeagueTableItem(
    onTeamClicked: (String) -> Unit,
    standing: Standing,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onTeamClicked("team/${standing.team.id}") }
            .padding(
                horizontal = dimensionResource(id = R.dimen.rs_padding_extra_small),
                vertical = dimensionResource(id = R.dimen.rs_padding_small),
            )
    ) {
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = standing.rank.toString(),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(
                    LocalContext.current
                ).data(standing.team.logo)
                    .build(),
                contentDescription = standing.team.name,
                modifier = modifier
                    .size(dimensionResource(id = R.dimen.rs_team_logo_size_medium))
            )
        }
        Column(
            modifier = modifier
                .weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = standing.team.name,
                style = MaterialTheme.typography.bodySmall,
            )
        }
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = standing.all.played.toString(),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = standing.all.win.toString(),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = standing.all.goals.forX.toString(),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = standing.points.toString(),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
    Divider()
}



@Composable
fun LeagueTableHeaderItem(
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.rs_padding_extra_small),
                vertical = dimensionResource(id = R.dimen.rs_padding_small),
            )
    ) {
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "#",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Column(
            modifier = modifier
                .weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Box(
                    modifier = modifier
                        .weight(.1f)
                )
                Text(
                    text = "Team",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = modifier
                        .weight(1f)
                )
            }
        }
        Box(
            modifier = modifier
                .weight(.2f)
        )
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "P",
                style = MaterialTheme.typography.bodySmall,
            )
        }
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "W",
                style = MaterialTheme.typography.bodySmall,
                fontSize = 14.sp

            )
        }
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "GD",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Column(
            modifier = modifier
                .weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "PTS",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
    Divider()
}