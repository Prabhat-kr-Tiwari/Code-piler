package com.prabhat.code_piler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.prabhat.code_piler.ui.theme.CodepilerTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.prabhat.code_piler.ui.theme.White
import com.prabhat.code_piler.ui.theme.components.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodepilerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = White
                ) {
                    Navigation()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodepilerTheme {

    }
}