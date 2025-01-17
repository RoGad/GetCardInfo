package alfa.android.cardinfoapp.di

import alfa.android.cardinfoapp.data.local.AppDatabase
import alfa.android.cardinfoapp.data.local.CardInfoDao
import alfa.android.cardinfoapp.data.remote.BinListApi
import alfa.android.cardinfoapp.data.repository.CardRepositoryImpl
import alfa.android.cardinfoapp.domain.repository.CardRepository
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBinListApi(): BinListApi {
        return Retrofit.Builder()
            .baseUrl(BinListApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinListApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "card_info_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCardInfoDao(database: AppDatabase): CardInfoDao {
        return database.cardInfoDao()
    }

    @Provides
    @Singleton
    fun provideCardRepository(api: BinListApi, cardInfoDao: CardInfoDao): CardRepository {
        return CardRepositoryImpl(api, cardInfoDao)
    }
}