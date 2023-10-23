package com.example.dialogscompose.dialogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DialogViewModel : ViewModel() {

    private val _isAlertDialogShown = MutableLiveData<Boolean>(false)
    internal val isAlertDialogShown: LiveData<Boolean> = _isAlertDialogShown

    private val _isCustomDialog = MutableLiveData<Boolean>(false)
    internal val isCustomDialog: LiveData<Boolean> = _isCustomDialog

    internal fun showAlertDialog(show: Boolean) = run { _isAlertDialogShown.value = show }

    internal fun showCustomDialog(show: Boolean) = run { _isCustomDialog.value = show }

}