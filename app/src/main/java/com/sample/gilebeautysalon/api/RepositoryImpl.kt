package com.sample.gilebeautysalon.api

import com.sample.gilebeautysalon.services.ServicesStates
import kotlinx.coroutines.flow.flow

class RepositoryImpl : Repository {

    override suspend fun getServices() = flow {

        emit(ServicesStates.Loading)
        val response = RetrofitClient.getInstance()?.apiService?.getServices()
        if (response!!.isSuccessful){
            emit(ServicesStates.Success(response.body()!!.data))
        }else{
            emit(ServicesStates.Error(response.errorBody().toString()))
        }

    }

}