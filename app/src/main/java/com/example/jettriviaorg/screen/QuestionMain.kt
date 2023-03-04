package com.example.jettriviaorg.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettriviaorg.model.ResponseJson

@Composable
fun QuestionMain(responseJson: ResponseJson.ResponseJsonItem, clickBtn: (Boolean) -> Unit) {


    var selectChoice by remember {
        mutableStateOf<Int?>(null)
    }
    var selectChoiceBack by remember {
        mutableStateOf(0)
    }

    var itsAnswer by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        //text is question api
        Text(
            text = responseJson.question,
            color = Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 30.dp)

        )

        //row question answer
        responseJson.choices.forEachIndexed { index, textAnswer ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .border(
                        width = 1.dp,
                        brush = Brush.linearGradient(colors = listOf(Color.Cyan, Color.Gray)),
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {

                RadioButton(selected = selectChoice == index, onClick = {
                    selectChoice = index
                    itsAnswer = responseJson.choices[index] == responseJson.answer

                    selectChoiceBack = index
                })

                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 18.sp, fontWeight = FontWeight.Light, color =
                            if (responseJson.choices[index] == responseJson.answer && itsAnswer) {
                                Color.Green
                            } else {
                                Color.White
                            }

                        )
                    ) {
                        append(textAnswer)
                    }
                }, modifier = Modifier.align(Alignment.CenterVertically))
            }


        }
        //button is next question
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)) {

            Button(onClick = {
                clickBtn(false)
                itsAnswer = true
                selectChoice = selectChoiceBack

            }, modifier = Modifier
                .weight(1f)
                .padding(5.dp)) {
                Text(text = "Back")
            }

            Button(onClick = {
                clickBtn(true)
                itsAnswer = false
                selectChoice = null

            }, modifier = Modifier
                .weight(1f)
                .padding(5.dp)) {
                Text(text = "Next")
            }

        }


    }

}