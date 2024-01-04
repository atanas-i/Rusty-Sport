package dev.rustybite.rustysport.data.dto.table


import com.google.gson.annotations.SerializedName
import dev.rustybite.rustysport.domain.model.Response

data class ResponseDto(
    @SerializedName("league")
    val league: LeagueDto
)

fun ResponseDto.toResponse(): Response =
    Response(league = league.toLeague())