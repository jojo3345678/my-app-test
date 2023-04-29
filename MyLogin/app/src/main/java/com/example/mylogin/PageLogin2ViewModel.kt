package com.example.mylogin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PageLogin2ViewModel : ViewModel() {
    val user: MutableLiveData<User> by lazy { MutableLiveData<User>() }

}