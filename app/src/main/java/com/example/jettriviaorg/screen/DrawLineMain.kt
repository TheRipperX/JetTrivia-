package com.example.jettriviaorg.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp


@Composable
fun DrawLineMain(line: PathEffect) {

    Canvas(modifier = Modifier.fillMaxWidth().height(1.dp).padding(5.dp)) {
        drawLine(color = Color.Gray, start = Offset(0f,0f), end = Offset(size.width,0f), pathEffect = line)
    }

}