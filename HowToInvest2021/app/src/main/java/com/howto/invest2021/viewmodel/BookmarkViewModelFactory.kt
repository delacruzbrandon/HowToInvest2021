package com.howto.invest2021.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.howto.invest2021.database.DetailsDatabaseDao

class BookmarkViewModelFactory(var detailsDao: DetailsDatabaseDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookmarkViewModel(detailsDao) as T
    }
}