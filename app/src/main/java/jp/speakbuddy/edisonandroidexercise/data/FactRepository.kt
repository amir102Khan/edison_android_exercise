package jp.speakbuddy.edisonandroidexercise.data

import jp.speakbuddy.edisonandroidexercise.data.repository.FactDataStore
import jp.speakbuddy.edisonandroidexercise.network.FactServiceProvider
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FactRepository @Inject constructor(private val factDataStore: FactDataStore) {
    suspend fun loadFacts() {
        val fact = FactServiceProvider.provide().getFact()
        factDataStore.saveFacts(fact)
    }

    fun getFacts() = factDataStore.getFacts()
}
