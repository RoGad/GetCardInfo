package alfa.android.cardinfoapp.domain.repository

import alfa.android.cardinfoapp.domain.model.CardInfo

interface CardRepository {
    suspend fun getCardInfo(bin: String): Result<CardInfo>
    suspend fun saveCardInfo(cardInfo: CardInfo, bin: String)
    suspend fun getCardHistory(): List<Pair<String, CardInfo>>
}
