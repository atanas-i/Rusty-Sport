package dev.rustybite.rustysport.data.dto.fixture


import com.google.gson.annotations.SerializedName

data class Parameters(
    @SerializedName("league")
    val league: String,
    @SerializedName("season")
    val season: String
)