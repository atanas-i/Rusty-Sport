package dev.rustybite.rustysport.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.rustybite.rustysport.data.remote.RustySportsApi
import dev.rustybite.rustysport.data.repository.LeagueTableRepository
import dev.rustybite.rustysport.domain.repository.LeagueTableRepositoryImpl
import dev.rustybite.rustysport.utils.RustySportsConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RustySportsModule {

    @Provides
    @Singleton
    fun providesRustySportsApi(): RustySportsApi =
        Retrofit.Builder()
            .baseUrl(RustySportsConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RustySportsApi::class.java)
    @Provides
    @Singleton
    fun provideLeagueTableRepository(api: RustySportsApi): LeagueTableRepository =
        LeagueTableRepositoryImpl(api)

}