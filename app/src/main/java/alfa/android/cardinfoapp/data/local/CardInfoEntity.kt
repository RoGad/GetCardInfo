package alfa.android.cardinfoapp.data.local

import alfa.android.cardinfoapp.domain.model.Bank
import alfa.android.cardinfoapp.domain.model.CardInfo
import alfa.android.cardinfoapp.domain.model.CardNumber
import alfa.android.cardinfoapp.domain.model.Country
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_info")
data class CardInfoEntity(
    @PrimaryKey val bin: String,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?,
    val countryNumeric: String?,
    val countryAlpha2: String?,
    val countryName: String?,
    val countryEmoji: String?,
    val countryCurrency: String?,
    val countryLatitude: Int?,
    val countryLongitude: Int?,
    val numberLength: Int?,
    val numberLuhn: Boolean?,
    val timestamp: Long = System.currentTimeMillis()
) {
    companion object {
        fun fromDomain(cardInfo: CardInfo, bin: String): CardInfoEntity {
            return CardInfoEntity(
                bin = bin,
                scheme = cardInfo.scheme,
                type = cardInfo.type,
                brand = cardInfo.brand,
                prepaid = cardInfo.prepaid,
                bankName = cardInfo.bank?.name,
                bankUrl = cardInfo.bank?.url,
                bankPhone = cardInfo.bank?.phone,
                bankCity = cardInfo.bank?.city,
                countryNumeric = cardInfo.country?.numeric,
                countryAlpha2 = cardInfo.country?.alpha2,
                countryName = cardInfo.country?.name,
                countryEmoji = cardInfo.country?.emoji,
                countryCurrency = cardInfo.country?.currency,
                countryLatitude = cardInfo.country?.latitude,
                countryLongitude = cardInfo.country?.longitude,
                numberLength = cardInfo.number?.length,
                numberLuhn = cardInfo.number?.luhn
            )
        }
    }

    fun toDomain(): CardInfo {
        return CardInfo(
            number = CardNumber(numberLength, numberLuhn),
            scheme = scheme,
            type = type,
            brand = brand,
            prepaid = prepaid,
            country = Country(
                numeric = countryNumeric,
                alpha2 = countryAlpha2,
                name = countryName,
                emoji = countryEmoji,
                currency = countryCurrency,
                latitude = countryLatitude,
                longitude = countryLongitude
            ),
            bank = Bank(
                name = bankName,
                url = bankUrl,
                phone = bankPhone,
                city = bankCity
            )
        )
    }
}
