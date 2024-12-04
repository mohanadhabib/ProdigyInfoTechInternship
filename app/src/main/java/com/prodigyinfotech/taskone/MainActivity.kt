package com.prodigyinfotech.taskone

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalConfiguration
import com.prodigyinfotech.taskone.ui.screens.CalculatorLandscapeScreen
import com.prodigyinfotech.taskone.ui.screens.CalculatorPortraitScreen
import com.prodigyinfotech.taskone.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorAppTheme {
                val isPortrait = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
                if(isPortrait){
                    CalculatorPortraitScreen()
                }
                else{
                    CalculatorLandscapeScreen()
                }
            }
        }
    }
}