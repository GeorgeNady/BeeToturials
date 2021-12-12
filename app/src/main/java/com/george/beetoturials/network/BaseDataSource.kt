package com.george.beetoturials.network

import com.george.beetoturials.models.login.LoginResponse
import com.george.beetoturials.utiles.Resource
import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException

@Suppress("LiftReturnOrAssignment")
abstract class BaseDataSource {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {
        Resource.loading(null)
        try {
            val response = apiCall()

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    return Resource.success(body)
                }
            } else {

                return Resource.error("and error !!")
            }

            return Resource.failed("Something went wrong, try again")


        } catch (t: Throwable) {
            when (t) {
                is IOException -> return Resource.failed("Network Failure, $t")
                else -> return Resource.failed("Conversion Error, $t")
            }

        }
    }

}