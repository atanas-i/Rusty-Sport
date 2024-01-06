package dev.rustybite.rustysport.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import dev.rustybite.rustysport.R

@Composable
fun RustySportsErrorBody(
    message: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = dimensionResource(id = R.dimen.rs_padding_large)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            modifier = modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}