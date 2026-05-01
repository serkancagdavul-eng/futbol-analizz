package com.example.futbolanaliz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)

    setContent {
        FutbolApp()
    }
}

}

@Composable
fun FutbolApp() {
var takim by remember { mutableStateOf("") }
var skorlar by remember { mutableStateOf(listOf<String>()) }

MaterialTheme {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("⚽ Canlı Futbol Skorları", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = takim,
            onValueChange = { takim = it },
            label = { Text("Takım adı gir") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                skorlar = listOf(
                    "$takim 2 - 1 Rakip",
                    "$takim 0 - 0 Rakip",
                    "$takim 3 - 2 Rakip"
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Skor Getir")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(skorlar) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

}
