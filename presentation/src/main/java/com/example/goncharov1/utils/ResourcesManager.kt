package com.example.goncharov1.utils

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface ResourcesManager {

    fun string(@StringRes id: Int): String

    class ResourcesManagerImpl @Inject constructor(
        @ApplicationContext val context: Context,
    ) : ResourcesManager {
        override fun string(id: Int): String = context.getString(id)
    }
}