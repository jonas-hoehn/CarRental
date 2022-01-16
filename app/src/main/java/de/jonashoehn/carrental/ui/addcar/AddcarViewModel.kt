package de.jonashoehn.carrental.ui.addcar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddcarViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is add Vehicle Fragment"
    }
    val text: LiveData<String> = _text
}