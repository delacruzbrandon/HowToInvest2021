package com.howto.invest2021.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.howto.invest2021.database.DetailsDatabaseDao
import com.howto.invest2021.model.DetailsModel
import kotlinx.coroutines.launch

class BookmarkViewModel(var detailsDao: DetailsDatabaseDao): ViewModel() {

    private val _allDetails = detailsDao.getAllDetails()
    val allDetails = Transformations.map(_allDetails) { it }

    fun onClearData() {
        viewModelScope.launch {
            clearBookmarks()
        }
    }

    private suspend fun clearBookmarks() {
        detailsDao.clearDetails()
    }
}