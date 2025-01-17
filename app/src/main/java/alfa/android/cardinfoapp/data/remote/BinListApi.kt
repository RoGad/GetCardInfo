package alfa.android.cardinfoapp.data.remote

import alfa.android.cardinfoapp.domain.model.CardInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BinListApi {
    @GET("{bin}")
    suspend fun getCardInfo(@Path("bin") bin: String): Response<CardInfo>

    companion object {
        const val BASE_URL = "https://lookup.binlist.net/"
    }
}
