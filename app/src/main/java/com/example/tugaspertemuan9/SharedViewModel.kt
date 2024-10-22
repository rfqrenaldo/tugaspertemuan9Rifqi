package com.example.tugaspertemuan9

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> get() = _username

    private val _number = MutableLiveData<String>()
    val number: LiveData<String> get() = _number

    private val _gender = MutableLiveData<String>()
    val gender: LiveData<String> get() = _gender

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun setUsername(username: String) {
        _username.value = username
    }

    fun setNumber(number: String) {
        _number.value = number
    }

    fun setGender(gender: String) {
        _gender.value = gender
    }

    fun clearData() {
        _email.value = ""
        _password.value = ""
        _username.value = ""
        _number.value = ""
        _gender.value = ""
    }
}