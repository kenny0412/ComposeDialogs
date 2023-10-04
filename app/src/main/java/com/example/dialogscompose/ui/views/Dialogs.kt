package com.example.dialogscompose.ui.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/*
    The Dialog component displays pop up messages or requests user input on a layer above the main app content.
    It creates an interruptive UI experience to capture user attention.

    Confirming user action, such as when deleting a file.
    Requesting user input, such as in a to-do list app.
    Presenting a list of options for user selection, like choosing a country in a profile setup.
 */

@Composable
fun AlertDialog(
    isShowed: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    if (isShowed)
        AlertDialog(
            onDismissRequest = { onDismissRequest() },
            confirmButton = { onConfirmation() },
            title = {
                Text(text = "Test")
            },
            text = {
                Text(text = "This is an example how alertDialog works")
            },
            icon = {
                Icon(Icons.Default.Info, contentDescription = "Info Icon")
            }
        )
}

@Composable
fun NativeDialog() {
    // TODO
}

@Composable
fun CustomDialog() {
    // TODO
}