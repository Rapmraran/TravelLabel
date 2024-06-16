package com.bangkit.travellabel.data

import com.bangkit.travellabel.data.api.ApiService
import com.bangkit.travellabel.data.pref.UserPreference
import com.bangkit.travellabel.data.response.ForumResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository private constructor(
    private val userPreference: UserPreference,
    private val apiService: ApiService
) {

    suspend fun getForum(token: String): Flow<Result<ForumResponse>> {
        val getFlow = flow {
            try {
                val forumResponse = apiService.getForum()
                emit(Result.success(forumResponse))
            } catch (error: Exception) {
                error.printStackTrace()
                emit(Result.failure(error))
            }
        }.flowOn(Dispatchers.IO)
        return getFlow
    }


//    companion object {
//        @Volatile
//        private var instance: Repository? = null
//        fun getInstance(
//            userPreference: UserPreference,
//            apiService: ApiService
//        ): Repository =
//            instance ?: synchronized(this) {
//                instance ?: Repository(userPreference, apiService)
//            }.also { instance = it }
//    }

    companion object {
        fun getInstance(userPreference: UserPreference, apiService: ApiService) = Repository(userPreference, apiService)
    }
}