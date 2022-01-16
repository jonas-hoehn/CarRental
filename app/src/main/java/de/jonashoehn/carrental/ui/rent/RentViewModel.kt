package de.jonashoehn.carrental.ui.rent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Vehicle Rental - Please scan CAR-ID"
    }
    val text: LiveData<String> = _text
}