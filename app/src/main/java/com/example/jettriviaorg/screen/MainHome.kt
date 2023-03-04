package com.example.jettriviaorg.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalContext
import com.example.jettriviaorg.model.ResponseJson
import com.example.jettriviaorg.viewmodel.AppViewModel


@Composable
fun MainHome(viewModel: AppViewModel) {

    val context = LocalContext.current
    val dataJson = viewModel.dataViewModel.value



    var jsonIndex by remember {
        mutableStateOf(0)
    }


    var progressAdd by remember {
        mutableStateOf(0f)
    }



    Surface(modifier = Modifier.fillMaxSize(), color = Color.DarkGray) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            if (dataJson.loading == true) {

                // colum an progress main activity
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                    CircularProgressIndicator(color = Color.Green)
                }
            } else {

                dataJson.data?.let {

                    if (jsonIndex >= 5){
                        //val getFloat = progressAdd

                        ProgressQuestion(progress = progressAdd)
                    }

                    // counter question main
                    CounterMainScreen(allQuestion = dataJson.data!!.count(), nextQuestion = jsonIndex)

                    // draw line
                    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(5f, 5f), 0f)
                    DrawLineMain(line = pathEffect)


                    //worker question and answer item
                    val json = dataJson.data as ResponseJson
                    val jsonIndexMain = json.toMutableList()[jsonIndex]

                    QuestionMain(responseJson = jsonIndexMain){
                        if (it){
                            jsonIndex++
                            progressAdd += 0.0001f
                        }
                        else{
                            if (jsonIndex > 0)
                                jsonIndex--
                        }
                    }
                }

                dataJson.e?.let {
                    if (!it.message.isNullOrEmpty())
                        Toast.makeText(context, "${dataJson.e?.message}", Toast.LENGTH_SHORT).show()
                    else{
                        Toast.makeText(context, "Please Check Is Connection :(", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

}