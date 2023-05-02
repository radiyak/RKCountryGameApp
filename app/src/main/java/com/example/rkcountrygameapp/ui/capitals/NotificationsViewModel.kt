package com.example.rkcountrygameapp.ui.capitals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Select a country from the dropdown to guess the capital."
    }
    val text: LiveData<String> = _text
}