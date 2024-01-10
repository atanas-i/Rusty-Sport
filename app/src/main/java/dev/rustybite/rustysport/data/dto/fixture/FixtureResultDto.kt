package dev.rustybite.rustysport.data.dto.fixture


import com.google.gson.annotations.SerializedName
import dev.rustybite.rustysport.domain.model.FixtureResult

data class FixtureResultDto(
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("get")
    val `get`: String,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("parameters")
    val parameters: Parameters,
    @SerializedName("response")
    val response: List<FixtureResponseDto>,
    @SerializedName("results")
    val results: Int
)

fun FixtureResultDto.toFixtureResult() =
    FixtureResult(
        response = response
    )