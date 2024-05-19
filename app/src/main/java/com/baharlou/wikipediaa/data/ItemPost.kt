package com.baharlou.wikipediaa.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemPost(
    val imgUrl: String,
    val title: String,
    val subtitle: String,
    val detail: String,

    //for trend fragment
    val isTrend: Boolean,
    val insight: String

) : Parcelable
