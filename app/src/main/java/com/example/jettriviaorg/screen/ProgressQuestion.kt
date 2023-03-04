package com.example.jettriviaorg.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProgressQuestion(progress: Float = 0.5f) {

    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 10.dp)) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
                .height(30.dp)
                .border(width =  2.dp, brush = Brush.linearGradient(listOf(Color.Red, Color.Blue)), shape = RoundedCornerShape(10.dp))
                .clip(shape = RoundedCornerShape(15.dp)),
            backgroundColor = Color.LightGray,
            color = Color.Red,
            progress = progress,

        )
    }
}