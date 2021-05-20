package com.howto.invest2021.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.howto.invest2021.model.DetailsModel

@Dao
interface DetailsDatabaseDao {

    @Insert
    suspend fun insertDetails(detailsModel: DetailsModel)

    @Query("DELETE FROM details_table")
    suspend fun clearDetails()

    @Query("SELECT * FROM details_table WHERE detailsId = :detailsKey")
    suspend fun getCurrentDetails(detailsKey: Long): DetailsModel?

    @Query("SELECT * FROM details_table ORDER BY detailsId DESC")
    fun getAllDetails(): LiveData<List<DetailsModel>>
}