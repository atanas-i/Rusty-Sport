package dev.rustybite.rustysport.domain.model

import dev.rustybite.rustysport.data.dto.table.StandingDto

data class League(
    val country: String,
    val flag: String,
    val id: Int,
    val logo: String,
    val name: String,
    val season: Int,
    val standings: List<List<StandingDto>>
)
