package com.howto.invest2021.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.howto.invest2021.database.DetailsDatabaseDao
import com.howto.invest2021.model.DetailsModel

class DetailsViewModelFactory(var detailsDao: DetailsDatabaseDao, var detailsModel: DetailsModel): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailsViewModel(detailsDao, detailsModel) as T
    }
}