package dev.rustybite.rustysport.data.dto.table


import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("league")
    val league: LeagueDto
)