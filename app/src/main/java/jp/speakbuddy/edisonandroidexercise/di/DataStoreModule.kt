package jp.speakbuddy.edisonandroidexercise.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.speakbuddy.edisonandroidexercise.common.Constants
import jp.speakbuddy.edisonandroidexercise.data.FactRepository
import jp.speakbuddy.edisonandroidexercise.data.repository.FactDataStore
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class FactRepoModule {
    @Provides
    fun providesFactRepository(apiServices: FactDataStore): FactRepository =
        FactRepository(apiServices)
}

@InstallIn(SingletonComponent::class)
@Module
class FactDataStoreModule {
    @Provides
    fun providesFactRepository(datastore: DataStore<Preferences>): FactDataStore =
        FactDataStore(datastore)
}

@InstallIn(SingletonComponent::class)
@Module
object DataStoreModule {
    @Singleton
    @Provides
    fun providesPreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile(Constants.FACT_DATA_PREFERENCE) }
        )
    }
}