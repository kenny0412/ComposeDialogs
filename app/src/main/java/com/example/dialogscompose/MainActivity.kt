package com.example.dialogscompose

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dialogscompose.ui.theme.DialogsComposeTheme
import com.example.dialogscompose.ui.views.AlertDialog

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
                    Container()
                }
            }
        }
    }
}

@Composable
fun Container() {
    var show by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { show = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)) {
            Text(text = "Dialogo alerta")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)) {
            Text(text = "Dialogo custom")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)) {
            Text(text = "Dialogo alerta")
        }
        AlertDialog(isShowed = show, onDismissRequest = { /*TODO*/ }, onConfirmation = {})
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    DialogsComposeTheme {
        Container()
    }
}