package dev.rustybite.rustysport.domain.repository

import dev.rustybite.rustysport.data.dto.table.TableDto
import dev.rustybite.rustysport.data.remote.RustySportsApi
import dev.rustybite.rustysport.data.repository.LeagueTableRepository
import dev.rustybite.rustysport.utils.RustySportsState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class LeagueTableRepositoryImpl @Inject constructor(
    private val api: RustySportsApi
) : LeagueTableRepository {
    override suspend fun getLeagueTable(season: Int, leagueId: Int): Flow<RustySportsState<TableDto>> = flow {
         try {
             emit(RustySportsState.Loading())
             val data = api.getLeagueTable(season, leagueId)
             emit(RustySportsState.Success(data))
         } catch (e: IOException) {
             emit(RustySportsState.Failure(e.message ?: "An unknown error occurred"))
         } catch (e: Exception) {
             emit(RustySportsState.Failure(e.message ?: "An unknown error occurred"))
         }
    }

}