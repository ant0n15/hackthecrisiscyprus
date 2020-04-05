package com.delivery.bakery.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delivery.bakery.data.StoresItem
import com.delivery.bakery.usecase.BakeryUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val bakeryUseCase: BakeryUseCase
) : ViewModel() {

    var stores: MutableLiveData<ArrayList<StoresItem>> = MutableLiveData()

    fun loadData() {
        viewModelScope.launch {
            stores = bakeryUseCase.onExecute(viewModelScope)
        }
    }
}
