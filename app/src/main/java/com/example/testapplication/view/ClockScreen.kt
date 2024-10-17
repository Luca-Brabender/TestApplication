package com.example.testapplication.view

import android.os.Build
import android.widget.TextClock
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.graphics.vector.ImageVector

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ClockScreen(){
    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ClockText()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomIconButton(Icons.Filled.PlayArrow)
            CustomIconButton(Icons.Filled.Refresh)
        }
    }
}

@Composable
fun ClockText() {
    AndroidView(
        factory = {context ->
            TextClock(context).apply {
                format12Hour?.let {this.format12Hour = "hh:mm:ss"}
                textSize.let { this.textSize = 30f }
            }
        }
    )
}

@Composable
fun CustomIconButton(iconPicture: ImageVector){
    IconButton(onClick = {}) {
        Icon(iconPicture, contentDescription = "Description")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showSystemUi = true)
fun ClockScreenPreview(){
    ClockScreen()
}