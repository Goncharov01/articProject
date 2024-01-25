package com.example.goncharov1.utils

import android.content.SharedPreferences

class SharedPreferencesHelper(private val sharedPreferences: SharedPreferences) {

    companion object {

        //User
        const val USER_NAME = "userName"
        const val USER_LAST_NAME = "userLastName"
        const val DATE_OF_BIRTH = "dateOfBirth"

    }

    var userName: String
        get() = sharedPreferences.getString(USER_NAME, "Unknown") ?: "Unknown"
        set(value) {
            sharedPreferences.edit().putString(USER_NAME, value).apply()
        }

    var userLastName: String
        get() = sharedPreferences.getString(USER_LAST_NAME, "Unknown") ?: "Unknown"
        set(value) {
            sharedPreferences.edit().putString(USER_LAST_NAME, value).apply()
        }

    var dateOfBirth: String
        get() = sharedPreferences.getString(DATE_OF_BIRTH, "Unknown") ?: "Unknown"
        set(value) {
            sharedPreferences.edit().putString(DATE_OF_BIRTH, value).apply()
        }
}