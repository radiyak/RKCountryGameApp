package com.example.rkcountrygameapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to the Country Game App. Click one of the tabs below to play a game."
    }
    val text: LiveData<String> = _text
}