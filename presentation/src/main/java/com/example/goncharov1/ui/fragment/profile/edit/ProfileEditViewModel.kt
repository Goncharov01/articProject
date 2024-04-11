package com.example.goncharov1.ui.fragment.profile.edit

import com.example.goncharov1.R
import com.example.goncharov1.ui.base.BaseViewModel
import com.example.goncharov1.utils.ResourcesManager
import com.example.goncharov1.utils.SharedPreferencesHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(
    private val resourcesManager: ResourcesManager,
    private val sharedPreferencesHelper: SharedPreferencesHelper,
) : BaseViewModel() {

    fun checkValidAndSaveData(name: String, lastName: String, dateOfBirth: String) {
        if (name.length !in 2..20) {
            sendError(resourcesManager.string(R.string.check_entered_name))
            return
        }
        if (lastName.length !in 2..20) {
            sendError(resourcesManager.string(R.string.check_entered_last_name))
            return
        }
        if (dateOfBirth.isEmpty()) {
            sendError(resourcesManager.string(R.string.check_entered_date_of_birth))
            return
        }

        sharedPreferencesHelper.userName = name
        sharedPreferencesHelper.userLastName = lastName
        sharedPreferencesHelper.dateOfBirth = dateOfBirth

        success()
    }
}