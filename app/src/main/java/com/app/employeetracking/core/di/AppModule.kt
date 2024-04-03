package com.app.employeetracking.core.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.app.employeetracking.features.auth.data.datasources.remote.AuthApi
import com.app.employeetracking.features.journey.data.datasources.remote.JourneyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ec2-54-86-119-176.compute-1.amazonaws.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext appContext: Context) : DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { appContext.preferencesDataStoreFile("employee_preferences") }
        )
    }

    @Provides
    @Singleton
    fun provideJourneyApi(retrofit: Retrofit) : JourneyApi {
        return retrofit
            .create(JourneyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit) : AuthApi {
        return retrofit
            .create(AuthApi::class.java)
    }
}