package alfa.android.cardinfoapp.presentation.viewmodel

import alfa.android.cardinfoapp.domain.model.CardInfo
import alfa.android.cardinfoapp.domain.repository.CardRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardInfoViewModel @Inject constructor(
    private val repository: CardRepository
) : ViewModel() {
    private val _cardInfo = MutableStateFlow<Result<CardInfo>?>(null)
    val cardInfo: StateFlow<Result<CardInfo>?> = _cardInfo.asStateFlow()

    private val _history = MutableStateFlow<List<Pair<String, CardInfo>>>(emptyList())
    val history: StateFlow<List<Pair<String, CardInfo>>> = _history.asStateFlow()

    fun fetchCardInfo(bin: String) {
        viewModelScope.launch {
            _cardInfo.value = repository.getCardInfo(bin)
            _cardInfo.value?.onSuccess { cardInfo ->
                repository.saveCardInfo(cardInfo, bin)
                loadHistory()
            }
        }
    }

    fun loadHistory() {
        viewModelScope.launch {
            _history.value = repository.getCardHistory()
        }
    }
}
