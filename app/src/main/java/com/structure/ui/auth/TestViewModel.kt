package com.structure.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class TestViewModel @Inject constructor(stateSavedStateHandle: SavedStateHandle): ViewModel() {
    // TODO: Implement the ViewModel

    var name = MutableLiveData<String>()
}
