package jp.speakbuddy.edisonandroidexercise.common

import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {
    const val FACT_DATA_PREFERENCE = "fact_data_preference"
    val FACT = stringPreferencesKey("fact")
    val LENGTH = intPreferencesKey("length")
}