package jp.speakbuddy.edisonandroidexercise.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import jp.speakbuddy.edisonandroidexercise.common.Constants
import jp.speakbuddy.edisonandroidexercise.network.FactResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


open class FactDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences> ){

    suspend fun saveFacts(response: FactResponse) {
        dataStore.edit {
            it[Constants.FACT] = response.fact
            it[Constants.LENGTH] = response.length
        }
    }

    fun getFacts(): Flow<FactResponse> = dataStore.data.map {
        FactResponse(
            fact = it[Constants.FACT].orEmpty(),
            length = it[Constants.LENGTH]?:0,
        )
    }
}