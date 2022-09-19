package com.example.wordsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _list: MutableLiveData<String> = MutableLiveData("A")
    val list: LiveData<String> get() = _list

    fun userInput(letter: String){
        _list.value = letter
    }
}