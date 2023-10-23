package com.example.dialogscompose.dialogs.ui.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.dialogscompose.R
import com.example.dialogscompose.ui.theme.DialogsComposeTheme

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
    onDismiss: () -> Unit
) {
    if (isShowed)
        AlertDialog(
            title = {
                Text(text = "Dialog with here icon")
            },
            text = {
                Text(text = "A dialog is a type of modal window that appears in front of app content to provide critical information, or ask for a decision.")
            },
            icon = {
                Icon(Icons.Default.Info, contentDescription = "Info Icon")
            },
            dismissButton = {
                Button(onClick = { onDismiss() }) {
                    Text(text = "dismiss")
                }
            },
            onDismissRequest = { onDismiss() },
            confirmButton = {
                Button(onClick = { onDismiss() }) {
                    Text(text = "confirm")
                }
            },
        )
}

@Composable
fun CustomDialog(
    isShowed: Boolean,
    onDismiss: () -> Unit
) {
    if (isShowed) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                DialogTitle("Set backup account")
                AccountItem(email = "example@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "example2@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Add account", drawable = R.drawable.add)
            }
        }
    }
}

@Composable
fun DialogTitle(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(24.dp)
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    DialogsComposeTheme {
        CustomDialog(isShowed = true) {}
    }
}