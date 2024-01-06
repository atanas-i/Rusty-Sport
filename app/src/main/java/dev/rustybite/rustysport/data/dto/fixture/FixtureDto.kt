package dev.rustybite.rustysport.data.dto.fixture


import com.google.gson.annotations.SerializedName
import dev.rustybite.rustysport.domain.model.Fixture

data class FixtureDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("periods")
    val periods: Periods,
    @SerializedName("referee")
    val referee: String,
    @SerializedName("status")
    val status: Status,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("venue")
    val venue: Venue
)

fun FixtureDto.toFixture(): Fixture =
    Fixture(
        date = date,
        id = id,
        periods = periods,
        referee = referee,
        status = status,
        timestamp = timestamp,
        timezone = timezone,
        venue = venue
    )