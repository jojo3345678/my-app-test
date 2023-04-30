package com.example.mylogin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Pageregister1ViewModel : ViewModel() {
    val name : MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val uid: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val password: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}