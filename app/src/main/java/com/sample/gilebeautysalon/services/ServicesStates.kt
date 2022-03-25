package com.sample.gilebeautysalon.services

import com.sample.gilebeautysalon.models.Data

sealed class ServicesStates{
    data class Success(val data: List<Data>) : ServicesStates()
    object Loading : ServicesStates()
    data class Error(val message: String) : ServicesStates()
}
