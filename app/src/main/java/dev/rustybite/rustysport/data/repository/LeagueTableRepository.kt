package dev.rustybite.rustysport.data.repository

import dev.rustybite.rustysport.data.dto.table.TableDto
import dev.rustybite.rustysport.utils.RustySportsState
import kotlinx.coroutines.flow.Flow

interface LeagueTableRepository {
    suspend fun getLeagueTable(
        season: Int,
        leagueId: Int
    ): Flow<RustySportsState<TableDto>>
}