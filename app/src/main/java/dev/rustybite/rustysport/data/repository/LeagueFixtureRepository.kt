package dev.rustybite.rustysport.data.repository

import dev.rustybite.rustysport.data.dto.fixture.FixtureResultDto
import dev.rustybite.rustysport.utils.RustySportsState
import kotlinx.coroutines.flow.Flow

interface LeagueFixtureRepository {

    suspend fun getLeagueFixture(season: Int, leagueId: Int): Flow<RustySportsState<FixtureResultDto>>

}