package dev.rustybite.rustysport.data.dto.table


import com.google.gson.annotations.SerializedName
import dev.rustybite.rustysport.domain.model.League

data class LeagueDto(
    @SerializedName("country")
    val country: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("season")
    val season: Int,
    @SerializedName("standings")
    val standings: List<List<StandingDto>>
)

fun LeagueDto.toLeague(): League =
    League(
        country = country,
        flag = flag,
        id = id,
        logo = logo,
        name = name,
        season = season,
        standings = standings
    )