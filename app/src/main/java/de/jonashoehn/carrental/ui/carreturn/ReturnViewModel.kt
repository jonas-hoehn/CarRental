package de.jonashoehn.carrental.ui.carreturn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReturnViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is return Fragment"
    }
    val text: LiveData<String> = _text
}