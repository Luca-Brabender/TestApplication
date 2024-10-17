package com.example.testapplication.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckListScreen(
    changeToClockScreen: () -> Unit
){
    Scaffold(
        topBar = { CenterAlignedTopAppBar({Text("Tasks")}) },
    ) { innerPadding ->
        val navController = rememberNavController()
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(innerPadding)
        ) {
            FormattedCheckItem()
            FormattedCheckItem()
            FormattedCheckItem()
        }
    }
}

@Composable
fun FormattedCheckItem(modifier: Modifier = Modifier){
    Row(Modifier.padding(10.dp)) {
        CheckItem(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun CheckItem(modifier: Modifier = Modifier){
    var checked by remember {mutableStateOf(true)}
    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
        .background(Color.LightGray)
        .fillMaxWidth()


    ) {
        Row(
            modifier = Modifier.padding(start = 15.dp)
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Text(
                text = if (checked) " Eingetragen" else "Bitte eintragen.",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(top = 13.dp)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun CheckListScreenPreview(){
    CheckListScreen({})
}