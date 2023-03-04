package com.example.jettriviaorg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jettriviaorg.screen.MainHome
import com.example.jettriviaorg.ui.theme.JetTriviaOrgTheme
import com.example.jettriviaorg.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    private val viewModelApp: AppViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTriviaOrgTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //viewModelApp.getAllViewModel()
                    Main(viewModelApp)
                }
            }
        }
    }
}

@Composable
fun Main(viewModel: AppViewModel) {

    Surface(modifier = Modifier.fillMaxSize()) {
        MainHome(viewModel)
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetTriviaOrgTheme {
        //Main()
    }
}