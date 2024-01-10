package dev.rustybite.rustysport.data.dto.fixture


import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import dev.rustybite.rustysport.domain.model.Fixture
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

data class FixtureDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("periods")
    val periods: Periods,
    @SerializedName("referee")
    val referee: String?,
    @SerializedName("status")
    val status: Status,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("venue")
    val venue: Venue
)

@RequiresApi(Build.VERSION_CODES.O)
fun FixtureDto.toFixture(): Fixture {
    val date = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(timestamp.toLong()),
        ZoneId.systemDefault()
    ).toLocalDate()
    val time = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(timestamp.toLong()),
        ZoneId.systemDefault()
    ).toLocalTime()
    return Fixture(
        id = id,
        date = date,
        time = time,
        periods = periods,
        referee = referee,
        status = status,
        venue = venue
    )
}