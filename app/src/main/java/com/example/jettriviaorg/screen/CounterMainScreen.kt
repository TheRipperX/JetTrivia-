package com.example.jettriviaorg.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettriviaorg.ui.theme.Teal200

@Preview
@Composable
fun CounterMainScreen(allQuestion: Int = 0, nextQuestion: Int = 0) {

    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textIndent = TextIndent.None)) {

            withStyle(style = SpanStyle(color = Teal200, fontWeight = FontWeight.Bold, fontSize = 30.sp)){

                append("Question: $nextQuestion/")

                withStyle(style = SpanStyle(color = Color.Green, fontSize = 20.sp)) {
                    append("$allQuestion")
                }
            }
        }
    }, modifier = Modifier.padding(10.dp))

}