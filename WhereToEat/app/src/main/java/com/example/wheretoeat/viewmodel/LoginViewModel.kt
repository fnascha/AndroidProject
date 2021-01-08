package com.example.wheretoeat.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel: ViewModel() {
    val email = MutableLiveData<String>()

    fun data(item: String) {
        email.value = item
    }

}