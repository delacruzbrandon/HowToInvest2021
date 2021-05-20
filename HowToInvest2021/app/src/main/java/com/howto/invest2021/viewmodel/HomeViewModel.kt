package com.howto.invest2021.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.howto.invest2021.dataservice.RetrofitBuilder
import com.howto.invest2021.model.DetailsModel
import kotlinx.coroutines.launch

class HomeViewModel(): ViewModel() {

    private val _detailList = MutableLiveData<List<DetailsModel>>()
    val detailList: LiveData<List<DetailsModel>>
        get() = _detailList

    private val response = RetrofitBuilder()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _detailList.value = getDataList()
        }
    }


    private suspend fun getDataList(): List<DetailsModel> {
        return response.requestDetailList()
    }
}