package com.howto.invest2021.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.howto.invest2021.database.DetailsDatabaseDao
import com.howto.invest2021.model.DetailsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(var detailsDao: DetailsDatabaseDao, var details: DetailsModel): ViewModel() {

    private val _detailsModel = MutableLiveData<DetailsModel>()
    val detailsModel: LiveData<DetailsModel>
    get() = _detailsModel

    private val _ifSavedEvent = MutableLiveData<Boolean>()
    val ifSavedEvent: LiveData<Boolean>
    get() = _ifSavedEvent

    init {
        initializeDetails()
    }

    private fun initializeDetails() {
        viewModelScope.launch(Dispatchers.Main) {
            _detailsModel.value = details
        }
    }

    fun onBookmark() {
        viewModelScope.launch {
            storeDetails(details)
            _ifSavedEvent.value = true
        }
    }

    private suspend fun storeDetails(details: DetailsModel) {
        return detailsDao.insertDetails(details)
    }
}