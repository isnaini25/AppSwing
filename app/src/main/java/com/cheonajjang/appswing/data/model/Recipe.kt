package com.cheonajjang.appswing.data.model

import android.os.Parcelable

import kotlinx.android.parcel.Parcelize


@Parcelize
data class Recipe(
    val id: Int = 0,
    val title: String = "",
    val image: String = "",
    val imageType: String = ""
    ) : Parcelable