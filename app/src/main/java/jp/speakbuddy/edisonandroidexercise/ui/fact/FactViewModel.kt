package jp.speakbuddy.edisonandroidexercise.ui.fact

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.speakbuddy.edisonandroidexercise.data.FactRepository
import jp.speakbuddy.edisonandroidexercise.network.FactResponse
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FactViewModel @Inject constructor(private val factRepository: FactRepository) : ViewModel() {
    var response by mutableStateOf(FactResponse("", 0))
        private set

    init {
        viewModelScope.launch {
            factRepository.getFacts().collect { factResponse ->
                response = factResponse
            }
        }
    }


     fun updateFact() {
        viewModelScope.launch {
            factRepository.loadFacts()
        }
     }

}
