package com.example.dialogscompose.dialogs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dialogscompose.dialogs.DialogViewModel
import com.example.dialogscompose.dialogs.ui.views.AlertDialog
import com.example.dialogscompose.dialogs.ui.views.CustomDialog
import com.example.dialogscompose.ui.theme.DialogsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun Container(dialogViewModel: DialogViewModel) {
    val isAlertDialogShown = dialogViewModel.isAlertDialogShown.observeAsState(false)
    val isCustomtDialogShown = dialogViewModel.isCustomDialog.observeAsState(false)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { dialogViewModel.showAlertDialog(true) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = "Alert dialog")
        }
        Button(
            onClick = { dialogViewModel.showCustomDialog(true) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = "Custom dialog")
        }
        AlertDialog(
            isShowed = isAlertDialogShown.value,
            onDismiss = { dialogViewModel.showAlertDialog(false) })
        CustomDialog(
            isShowed = isCustomtDialogShown.value,
            onDismiss = { dialogViewModel.showCustomDialog(false) })
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    DialogsComposeTheme {
        Container(DialogViewModel())
    }
}