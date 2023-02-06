package com.example.rick_morty_android.model

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.net.URL

@Parcelize
data class Note(
    val image: String,
    val titulo: String,
    val descricao: String
): Parcelable

