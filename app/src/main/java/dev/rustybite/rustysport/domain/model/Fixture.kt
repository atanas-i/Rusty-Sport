package dev.rustybite.rustysport.domain.model

import dev.rustybite.rustysport.data.dto.fixture.Periods
import dev.rustybite.rustysport.data.dto.fixture.Status
import dev.rustybite.rustysport.data.dto.fixture.Venue

data class Fixture(
    val date: String,
    val id: Int,
    val periods: Periods,
    val referee: String,
    val status: Status,
    val timestamp: Int,
    val timezone: String,
    val venue: Venue
)
