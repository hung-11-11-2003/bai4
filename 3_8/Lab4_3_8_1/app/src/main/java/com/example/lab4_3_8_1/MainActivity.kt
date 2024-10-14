package com.example.lab4_3_8_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sử dụng Jetpack Compose để xây dựng UI
        setContent {
            MyAppTheme { // Áp dụng chủ đề MyAppTheme (hỗ trợ Dark Mode)
                MyApp() // Gọi hàm giao diện chính
            }
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Jetpack Compose Demo") }
            )
        }
    ) { contentPadding ->
        // Nội dung chính của giao diện với contentPadding
        MainContent(modifier = Modifier.padding(contentPadding))
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    // Biến trạng thái để theo dõi số lần nhấn nút
    var count by remember { mutableStateOf(0) }

    // Giao diện chính với Column
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // Thêm padding cho nội dung
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Hiển thị số lần nhấn nút
        Text(
            text = "You clicked the button $count times",
            style = MaterialTheme.typography.h5
        )

        // Khoảng cách giữa Text và Button
        Spacer(modifier = Modifier.height(16.dp))

        // Nút nhấn sử dụng Button của Material Design
        Button(
            onClick = { count++ },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
        ) {
            Text("Click Me!")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppTheme {
        MyApp()
    }
}
