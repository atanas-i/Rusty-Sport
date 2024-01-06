package dev.rustybite.rustysport.data.dto.fixture


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

fun FixtureResponseDto.toFixtureResponse() =
    FixtureResponse(
        fixture = fixture,
        goals = goals,
        league = league,
        score = score,
        teams = teams
    )