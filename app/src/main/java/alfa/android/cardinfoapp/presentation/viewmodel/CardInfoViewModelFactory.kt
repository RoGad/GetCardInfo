package alfa.android.cardinfoapp.presentation.viewmodel

import alfa.android.cardinfoapp.domain.repository.CardRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CardInfoViewModelFactory(
    private val repository: CardRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardInfoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CardInfoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
