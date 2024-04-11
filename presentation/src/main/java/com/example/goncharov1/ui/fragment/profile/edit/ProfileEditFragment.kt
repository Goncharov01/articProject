package com.example.goncharov1.ui.fragment.profile.edit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.goncharov1.R
import com.example.goncharov1.databinding.FragmentProfileEditBinding
import com.example.goncharov1.ui.base.BaseFragment
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date

@AndroidEntryPoint
class ProfileEditFragment : BaseFragment(R.layout.fragment_profile_edit) {

    private val binding: FragmentProfileEditBinding by viewBinding()
    override val viewModel: ProfileEditViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnSave.setOnClickListener {
                saveUserData()
            }

            toolbar.setNavigationOnClickListener {
                goBack()
            }

            dateOfBirth.setOnClickListener {
                showDataPicker()
            }
        }
    }

    private fun saveUserData() {
        with(binding) {
            val name = edName.text.trim().toString()
            val lastName = edLastName.text.trim().toString()
            val dateOfBirth = dateOfBirth.text.trim().toString()

            viewModel.checkValidAndSaveData(
                name = name,
                lastName = lastName,
                dateOfBirth = dateOfBirth
            )
        }
    }

    private fun showDataPicker() {
        val dataPicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText(getString(R.string.select_date_birth))
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        dataPicker.addOnPositiveButtonClickListener {
            binding.dateOfBirth.text =
                SimpleDateFormat(getString(R.string.date_format)).format(Date(it))
        }
        dataPicker.show(childFragmentManager, getString(R.string.tag_data_picker))
    }

    override fun success() {
        showToast(getString(R.string.data_saved))
        goBack()
    }
}