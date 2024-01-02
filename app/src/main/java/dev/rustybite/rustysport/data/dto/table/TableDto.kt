package dev.rustybite.rustysport.data.dto.table


import com.google.gson.annotations.SerializedName
import dev.rustybite.rustysport.domain.model.Table

data class TableDto(
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("get")
    val `get`: String,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("parameters")
    val parameters: Parameters,
    @SerializedName("response")
    val response: List<ResponseDto>,
    @SerializedName("results")
    val results: Int
)

fun TableDto.toTable(): Table =
    Table(response = response)