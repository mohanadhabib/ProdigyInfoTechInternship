package com.prodigyinfotech.taskone.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(modifier: Modifier, txt:String,txtPadding:Dp = 18.dp ,  txtColor: Color, isText:Boolean = true, onClick:()->Unit){
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = CircleShape
    ) {
        if(isText){
            Text(
                modifier = Modifier.padding(vertical = txtPadding),
                text = txt,
                color = txtColor,
                fontSize = 22.sp,
            )
        }
        else{
            Icon(
                modifier = Modifier.padding(vertical = txtPadding),
                imageVector = Icons.Default.Clear,
                tint = Color.White,
                contentDescription = "")
        }
    }
}