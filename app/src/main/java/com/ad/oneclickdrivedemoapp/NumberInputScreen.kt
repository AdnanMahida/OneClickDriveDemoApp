package com.ad.oneclickdrivedemoapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.ad.oneclickdrivedemoapp.ui.theme.OneClickDriveDemoAppTheme

@Composable
fun NumberInputScreen(viewModel: NumberInputViewModel, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = viewModel.input1,
            onValueChange = viewModel::setInput1Value,
            label = { Text(text = "Enter numbers (e.g., 1,2,3,4)") })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.input2,
            onValueChange = viewModel::setInput2Value,
            label = { Text("Enter numbers (e.g., 1,2,3,4)") })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.input3,
            onValueChange = viewModel::setInput3Value,
            label = { Text("Enter numbers (e.g., 1,2,3,4)") })
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            viewModel.calculateResult()
        }, enabled = viewModel.isButtonEnabled) {
            Text("Calculate")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            viewModel.resultStr,
            modifier = Modifier.padding(16.dp),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OneClickDriveDemoAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            NumberInputScreen(NumberInputViewModel(), Modifier.padding(innerPadding))
        }
    }
}