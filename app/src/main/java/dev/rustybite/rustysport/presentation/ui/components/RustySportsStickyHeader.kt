package dev.rustybite.rustysport.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import dev.rustybite.rustysport.R

@Composable
fun RustySportsStickyHeader(
    headerTitle: String,
    modifier: Modifier
) {
    Text(
        text = headerTitle,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.rs_padding_medium),
            )
            .background(MaterialTheme.colorScheme.background)
    )
}