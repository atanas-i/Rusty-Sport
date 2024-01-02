package dev.rustybite.rustysport.data.repository

import dev.rustybite.rustysport.data.dto.table.TableDto

interface LeagueTableRepository {
    suspend fun getLeagueTable(
        season: Int,
        leagueId: Int
    ): TableDto
}