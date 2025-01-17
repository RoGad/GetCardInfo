package alfa.android.cardinfoapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CardInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cardInfo: CardInfoEntity)

    @Query("SELECT * FROM card_info ORDER BY timestamp DESC")
    suspend fun getAllCardInfo(): List<CardInfoEntity>

    @Query("SELECT * FROM card_info WHERE bin = :bin")
    suspend fun getCardInfoByBin(bin: String): CardInfoEntity?
}
