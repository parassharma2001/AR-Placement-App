package com.example.arplacement.ui.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.arplacement.ui.helpers.DrillData


class DrillDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val drillId = intent.getIntExtra("drillId", 1)
        val drill = DrillData.drills.find { it.id == drillId } ?: DrillData.drills.first()

        setContent {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(drill.name, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Description: ${drill.description}")
                Text("Tips: ${drill.tips}")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    startActivity(Intent(this@DrillDetailActivity, ArActivity::class.java))
                }) {
                    Text("Launch AR")
                }
            }
        }
    }
}