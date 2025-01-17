package alfa.android.cardinfoapp.data.repository

import alfa.android.cardinfoapp.data.local.CardInfoDao
import alfa.android.cardinfoapp.data.local.CardInfoEntity
import alfa.android.cardinfoapp.data.remote.BinListApi
import alfa.android.cardinfoapp.domain.model.CardInfo
import alfa.android.cardinfoapp.domain.repository.CardRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardRepositoryImpl @Inject constructor(
    private val api: BinListApi,
    private val cardInfoDao: CardInfoDao
) : CardRepository {
    override suspend fun getCardInfo(bin: String): Result<CardInfo> {
        return try {
            val response = api.getCardInfo(bin)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Failed to fetch card info"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun saveCardInfo(cardInfo: CardInfo, bin: String) {
        cardInfoDao.insert(CardInfoEntity.fromDomain(cardInfo, bin))
    }

    override suspend fun getCardHistory(): List<Pair<String, CardInfo>> {
        return cardInfoDao.getAllCardInfo().map {
            Pair(it.bin, it.toDomain())
        }
    }
}
