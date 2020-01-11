package com.structure.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SharedViewModel @Inject constructor(): ViewModel() {
    // TODO: Implement the ViewModel

    var data = MutableLiveData<String>()


}
