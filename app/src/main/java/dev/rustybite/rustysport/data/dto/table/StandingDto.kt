package dev.rustybite.rustysport.data.dto.table


import com.google.gson.annotations.SerializedName
import dev.rustybite.rustysport.domain.model.Standing

data class StandingDto(
    @SerializedName("all")
    val all: All,
    @SerializedName("away")
    val away: Away,
    @SerializedName("description")
    val description: String?,
    @SerializedName("form")
    val form: String,
    @SerializedName("goalsDiff")
    val goalsDiff: Int,
    @SerializedName("group")
    val group: String,
    @SerializedName("home")
    val home: Home,
    @SerializedName("points")
    val points: Int,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("team")
    val team: Team,
    @SerializedName("update")
    val update: String
)

fun StandingDto.toStanding(): Standing =
    Standing(
        all = all,
        away = away,
        description = description,
        form = form,
        goalsDiff = goalsDiff,
        group = group,
        home = home,
        points = points,
        rank = rank,
        status = status,
        team = team,
        update = update
    )