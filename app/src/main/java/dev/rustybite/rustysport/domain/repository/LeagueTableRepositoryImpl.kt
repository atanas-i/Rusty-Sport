package dev.rustybite.rustysport.domain.repository

import dev.rustybite.rustysport.data.dto.table.TableDto
import dev.rustybite.rustysport.data.remote.RustySportsApi
import dev.rustybite.rustysport.data.repository.LeagueTableRepository
import javax.inject.Inject

class LeagueTableRepositoryImpl @Inject constructor(
    private val api: RustySportsApi
) : LeagueTableRepository {
    override suspend fun getLeagueTable(season: Int, leagueId: Int): TableDto {
        return api.getLeagueTable(season, leagueId)
    }

}