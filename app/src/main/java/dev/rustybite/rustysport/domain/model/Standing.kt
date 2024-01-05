package dev.rustybite.rustysport.domain.model

import dev.rustybite.rustysport.data.dto.table.All
import dev.rustybite.rustysport.data.dto.table.Away
import dev.rustybite.rustysport.data.dto.table.Home
import dev.rustybite.rustysport.data.dto.table.Team

data class Standing(
    val all: All,
    val away: Away,
    val description: String?,
    val form: String,
    val goalsDiff: Int,
    val group: String,
    val home: Home,
    val points: Int,
    val rank: Int,
    val status: String,
    val team: Team,
    val update: String
)
