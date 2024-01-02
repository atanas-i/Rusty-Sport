package dev.rustybite.rustysport.data.dto.table


import com.google.gson.annotations.SerializedName

data class Goals(
    @SerializedName("against")
    val against: Int,
    @SerializedName("for")
    val forX: Int
)