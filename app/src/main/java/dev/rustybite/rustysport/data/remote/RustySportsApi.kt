package dev.rustybite.rustysport.data.remote

import dev.rustybite.rustysport.data.dto.fixture.FixtureResultDto
import dev.rustybite.rustysport.data.dto.table.TableDto
import dev.rustybite.rustysport.utils.RustySportsConstants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RustySportsApi {
    @GET("standings")
    @Headers("X-RapidAPI-Key: ${RustySportsConstants.API_KEY}")
    suspend fun getLeagueTable(
        @Query("season") season: Int,
        @Query("league") leagueId: Int
    ): TableDto

    @GET("fixtures")
    @Headers("X-RapidAPI-Key: ${RustySportsConstants.API_KEY}")
    suspend fun getLeagueFixture(
        @Query("season") season: Int,
        @Query("league") leagueId: Int
    ): FixtureResultDto
}