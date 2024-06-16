package com.coba.storyapp.di

import android.content.Context
import com.bangkit.travellabel.data.Repository
import com.bangkit.travellabel.data.api.ApiConfig
import com.bangkit.travellabel.data.pref.UserPreference
import com.bangkit.travellabel.data.pref.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): Repository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return Repository.getInstance(pref, apiService)
    }
}