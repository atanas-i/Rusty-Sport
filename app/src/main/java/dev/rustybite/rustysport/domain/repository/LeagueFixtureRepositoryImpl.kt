package dev.rustybite.rustysport.domain.repository

import dev.rustybite.rustysport.data.dto.fixture.FixtureResultDto
import dev.rustybite.rustysport.data.remote.RustySportsApi
import dev.rustybite.rustysport.data.repository.LeagueFixtureRepository
import dev.rustybite.rustysport.utils.RustySportsState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class LeagueFixtureRepositoryImpl @Inject constructor(
    private val api: RustySportsApi
) : LeagueFixtureRepository {
    override suspend fun getLeagueFixture(
        season: Int,
        leagueId: Int
    ): Flow<RustySportsState<FixtureResultDto>> = flow {
        try {
            emit(RustySportsState.Loading())
            val data = api.getLeagueFixture(season, leagueId)
            emit(RustySportsState.Success(data))
        } catch (e: IOException) {
            emit(RustySportsState.Failure(e.message ?: "An unknown error occurred"))
        } catch (e: Exception) {
            emit(RustySportsState.Failure(e.message ?: "An unknown error occurred"))
        }
    }
}