package com.example.arplacement.ui.screen

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.arplacement.ui.helpers.DrillData
import androidx.compose.ui.platform.LocalContext

@Composable
fun DrillSelectionScreen() {
    val context = LocalContext.current
    var selectedDrill by remember { mutableStateOf(DrillData.drills.first()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text("Select Drill:", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(8.dp))

        var expanded by remember { mutableStateOf(false) }
        Box {
            Button(onClick = { expanded = true }) {
                Text(selectedDrill.name)
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                DrillData.drills.forEach { drill ->
                    DropdownMenuItem(onClick = {
                        selectedDrill = drill
                        expanded = false
                    }, text = { Text(drill.name) })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val intent = Intent(context, DrillDetailActivity::class.java)
            intent.putExtra("drillId", selectedDrill.id)
            context.startActivity(intent)
        }) {
            Text("Start AR Drill")
        }
    }
}