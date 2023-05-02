package com.example.rkcountrygameapp.ui.locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Select a country from the dropdown to get location image."
    }
    val text: LiveData<String> = _text
}