package com.howto.invest2021.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Entity(tableName = "details_table")
@Parcelize
data class DetailsModel(
    @PrimaryKey(autoGenerate = true)
    var detailsId: Long = 0L,

    @SerializedName("subtitle")
    @ColumnInfo(name = "subtitle")
    var title: String,

    @SerializedName("descriptions")
    @ColumnInfo(name = "body")
    var body: String,

    @SerializedName("business_type")
    @ColumnInfo(name = "type")
    var type: String,

    @SerializedName("effort")
    @ColumnInfo(name = "effort")
    var effort: String,

    @SerializedName("leverage")
    @ColumnInfo(name = "leverage")
    var leverage: String

    ) : Parcelable {
    override fun toString(): String {
        return "\n\nTitle: $title" +
                "\nType: $type" +
                "\nEffort: $effort" +
                "\nLeverage: $leverage" +
                "\nBody: $body"
    }
}