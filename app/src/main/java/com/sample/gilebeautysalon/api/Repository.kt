package com.sample.gilebeautysalon.api

import com.sample.gilebeautysalon.services.ServicesStates
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getServices() : Flow<ServicesStates>
}