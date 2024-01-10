package dev.rustybite.rustysport.domain.model

import dev.rustybite.rustysport.data.dto.fixture.Periods
import dev.rustybite.rustysport.data.dto.fixture.Status
import dev.rustybite.rustysport.data.dto.fixture.Venue
import java.time.LocalDate
import java.time.LocalTime

data class Fixture(
    val id: Int,
    val date: LocalDate,
    val time: LocalTime,
    val periods: Periods,
    val referee: String?,
    val status: Status,
    val venue: Venue
)
