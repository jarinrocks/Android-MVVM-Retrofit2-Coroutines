package com.sample.gilebeautysalon.services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.gilebeautysalon.api.RepositoryImpl
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ServicesViewModel : ViewModel() {

    private val _servicesStates = MutableLiveData<ServicesStates>()
    val servicesStates :LiveData<ServicesStates> get() = _servicesStates

    init {

        viewModelScope.launch {
            RepositoryImpl().getServices().collect {
                _servicesStates.value = it
            }
        }

    }

}