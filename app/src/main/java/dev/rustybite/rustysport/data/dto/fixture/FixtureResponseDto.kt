package dev.rustybite.rustysport.data.dto.fixture


import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import dev.rustybite.rustysport.domain.model.FixtureResponse

data class FixtureResponseDto(
    @SerializedName("fixture")
    val fixture: FixtureDto,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("league")
    val league: League,
    @SerializedName("score")
    val score: Score,
    @SerializedName("teams")
    val teams: Teams
)

@RequiresApi(Build.VERSION_CODES.O)
fun FixtureResponseDto.toFixtureResponse() =
    FixtureResponse(
        fixture = fixture.toFixture(),
        goals = goals,
        league = league,
        score = score,
        teams = teams
    )