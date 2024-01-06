package dev.rustybite.rustysport.domain.model

import dev.rustybite.rustysport.data.dto.fixture.FixtureDto
import dev.rustybite.rustysport.data.dto.fixture.Goals
import dev.rustybite.rustysport.data.dto.fixture.League
import dev.rustybite.rustysport.data.dto.fixture.Score
import dev.rustybite.rustysport.data.dto.fixture.Teams

data class FixtureResponse(
    val fixture: FixtureDto,
    val goals: Goals,
    val league: League,
    val score: Score,
    val teams: Teams
)
