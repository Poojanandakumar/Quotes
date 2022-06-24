package com.prototype.shared.di

import android.content.Context
import androidx.room.Room
import com.prototype.model.room.FavouriteQuoteDao
import com.prototype.model.room.FavouriteQuoteRoomDatabase
import com.prototype.shared.data.DefaultQuotesRepository
import com.prototype.shared.data.QuotesDataSource
import com.prototype.shared.data.QuotesRepository
import com.prototype.shared.data.RestApiQuotesDataSource
import com.prototype.shared.domain.GetQuotesUseCase
import com.prototype.shared.util.QuotesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideQuotesRepository(quotesDataSource: QuotesDataSource): QuotesRepository {
        return DefaultQuotesRepository(quotesDataSource)
    }

    @Singleton
    @Provides
    fun provideNoteDataSource(api: QuotesApi): QuotesDataSource {
        return RestApiQuotesDataSource(api)
    }

    @Singleton
    @Provides
    fun provideNoteDataUseCase(quotesRepository: QuotesRepository): GetQuotesUseCase {
        return GetQuotesUseCase(quotesRepository)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.quotable.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApi(retrofit: Retrofit): QuotesApi {
        return retrofit.create(QuotesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideFavouriteQuotesDAO(appDatabase: FavouriteQuoteRoomDatabase): FavouriteQuoteDao {
        return appDatabase.favouriteQuoteDao()
    }

    @Singleton
    @Provides
    fun provideSearchDatabase(@ApplicationContext context : Context):FavouriteQuoteRoomDatabase{
       return Room.databaseBuilder(context, FavouriteQuoteRoomDatabase::class.java, "favouriteQuote_database")
            .build()
    }


}