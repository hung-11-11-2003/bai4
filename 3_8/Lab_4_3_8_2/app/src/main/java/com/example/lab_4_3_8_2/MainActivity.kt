package com.example.lab_4_3_8_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab_4_3_8_2.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
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
                title = { Text("Todo List") } // Tiêu đề cho ứng dụng
            )
        }
    ) { innerPadding ->
        // Nội dung chính của giao diện
        MainContent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    var taskInput by remember { mutableStateOf(TextFieldValue("")) } // Biến để lưu tên công việc
    // Sử dụng remember để khởi tạo danh sách công việc
    val taskList = remember { mutableStateListOf<String>() } // Danh sách công việc

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        // TextField để nhập tên công việc
        TextField(
            value = taskInput,
            onValueChange = { taskInput = it },
            label = { Text("Enter task") }, // Nhãn cho TextField
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Nút Add để thêm công việc vào danh sách
        Button(
            onClick = {
                if (taskInput.text.isNotBlank()) { // Kiểm tra nếu ô nhập không trống
                    taskList.add(taskInput.text) // Thêm công việc vào danh sách
                    taskInput = TextFieldValue("") // Đặt lại ô nhập
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Task") // Dòng chữ trên nút
        }

        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn để hiển thị danh sách công việc
        LazyColumn {
            items(taskList) { task ->
                TaskItem(task = task, onDelete = { taskList.remove(task) }) // Hiển thị từng công việc
            }
        }
    }
}

@Composable
fun TaskItem(task: String, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = task) // Hiển thị tên công việc
            Button(onClick = onDelete) { // Nút Delete để xóa công việc
                Text("Delete") // Dòng chữ trên nút
            }
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
