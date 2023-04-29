package com.example.mylogin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PageLogin1ViewModel : ViewModel() {
    val uid: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val password: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}