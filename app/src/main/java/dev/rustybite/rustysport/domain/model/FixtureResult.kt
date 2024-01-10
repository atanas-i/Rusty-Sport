package dev.rustybite.rustysport.domain.model

import dev.rustybite.rustysport.data.dto.fixture.FixtureResponseDto

data class FixtureResult(
    val response: List<FixtureResponseDto>,
)
