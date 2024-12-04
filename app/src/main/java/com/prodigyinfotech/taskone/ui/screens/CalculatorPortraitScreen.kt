package com.prodigyinfotech.taskone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.prodigyinfotech.taskone.ui.composables.CalculatorButton
import com.prodigyinfotech.taskone.data.calculate
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@OptIn(DelicateCoroutinesApi::class)
@Composable
fun CalculatorPortraitScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp)
    ) {
        // Composable views references
        val (btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9) = createRefs()
        val (btnPlus, btnMinus, btnMultiply, btnDivision, btnDot, btnClear, btnDelete, btnEqual) = createRefs()
        val (txtCalculation, txtResult) = createRefs()

        // State variables
        var currentTxt by remember { mutableStateOf("") }
        var resultTxt by remember { mutableStateOf("") }

        // First Row
        CalculatorButton(
            modifier = Modifier.constrainAs(btn0) {
                bottom.linkTo(parent.bottom, margin = 50.dp)
                start.linkTo(parent.start, margin = 10.dp)
                end.linkTo(btnDot.start, margin = 10.dp)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "0"
        ) {
            currentTxt += "0"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btnDot) {
                top.linkTo(btn0.top)
                bottom.linkTo(btn0.bottom)
                start.linkTo(btn0.end, margin = 10.dp)
                end.linkTo(btnClear.start, margin = 10.dp)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "."
        ) {
            currentTxt += "."
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btnClear) {
                top.linkTo(btn0.top)
                bottom.linkTo(btn0.bottom)
                start.linkTo(btnDot.end, margin = 10.dp)
                end.linkTo(btnEqual.start, margin = 10.dp)

                width = Dimension.fillToConstraints
            },
            txtColor = MaterialTheme.colorScheme.errorContainer,
            txt = "C"
        ) {
            currentTxt = ""
            resultTxt = ""
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btnEqual) {
                top.linkTo(btn0.top)
                bottom.linkTo(btn0.bottom)
                start.linkTo(btnClear.end, margin = 10.dp)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.White,
            txt = "="
        ) {
            if (currentTxt.isNotEmpty() && resultTxt.isNotEmpty()) {
                currentTxt = ""
                resultTxt = ""
            } else {
                GlobalScope.launch {
                    resultTxt = calculate(currentTxt).toString()
                }
            }
        }

        // Second Row
        CalculatorButton(
            modifier = Modifier.constrainAs(btn1) {
                bottom.linkTo(btn0.top, margin = 10.dp)
                start.linkTo(btn0.start)
                end.linkTo(btn0.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "1"
        ) {
            currentTxt += "1"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btn2) {
                top.linkTo(btn1.top)
                bottom.linkTo(btn1.bottom)
                start.linkTo(btnDot.start)
                end.linkTo(btnDot.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "2"
        ) {
            currentTxt += "2"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btn3) {
                top.linkTo(btn2.top)
                bottom.linkTo(btn2.bottom)
                start.linkTo(btnClear.start)
                end.linkTo(btnClear.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "3"
        ) {
            currentTxt += "3"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btnPlus) {
                top.linkTo(btn3.top)
                bottom.linkTo(btn3.bottom)
                start.linkTo(btnEqual.start)
                end.linkTo(btnEqual.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "+"
        ) {
            currentTxt += "+"
        }

        // Third Row
        CalculatorButton(
            modifier = Modifier.constrainAs(btn4) {
                bottom.linkTo(btn1.top, margin = 10.dp)
                start.linkTo(btn1.start)
                end.linkTo(btn1.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "4"
        ) {
            currentTxt += "4"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btn5) {
                top.linkTo(btn4.top)
                bottom.linkTo(btn4.bottom)
                start.linkTo(btn2.start)
                end.linkTo(btn2.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "5"
        ) {
            currentTxt += "5"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btn6) {
                top.linkTo(btn5.top)
                bottom.linkTo(btn5.bottom)
                start.linkTo(btn3.start)
                end.linkTo(btn3.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "6"
        ) {
            currentTxt += "6"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btnMinus) {
                top.linkTo(btn6.top)
                bottom.linkTo(btn6.bottom)
                start.linkTo(btnPlus.start)
                end.linkTo(btnPlus.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "-"
        ) {
            currentTxt += "-"
        }

        // Fourth Row
        CalculatorButton(
            modifier = Modifier.constrainAs(btn7) {
                bottom.linkTo(btn4.top, margin = 10.dp)
                start.linkTo(btn4.start)
                end.linkTo(btn4.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "7"
        ) {
            currentTxt += "7"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btn8) {
                top.linkTo(btn7.top)
                bottom.linkTo(btn7.bottom)
                start.linkTo(btn5.start)
                end.linkTo(btn5.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "8"
        ) {
            currentTxt += "8"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btn9) {
                top.linkTo(btn8.top)
                bottom.linkTo(btn8.bottom)
                start.linkTo(btn6.start)
                end.linkTo(btn6.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "9"
        ) {
            currentTxt += "9"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btnMultiply) {
                top.linkTo(btn9.top)
                bottom.linkTo(btn9.bottom)
                start.linkTo(btnMinus.start)
                end.linkTo(btnMinus.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "x"
        ) {
            currentTxt += "x"
        }

        // Fifth Row
        CalculatorButton(
            modifier = Modifier.constrainAs(btnDivision) {
                bottom.linkTo(btnMultiply.top, margin = 10.dp)
                start.linkTo(btnMultiply.start)
                end.linkTo(btnMultiply.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            txt = "/"
        ) {
            currentTxt += "/"
        }

        CalculatorButton(
            modifier = Modifier.constrainAs(btnDelete) {
                top.linkTo(btnDivision.top)
                bottom.linkTo(btnDivision.bottom)
                start.linkTo(btn9.start)
                end.linkTo(btn9.end)

                width = Dimension.fillToConstraints
            },
            txtColor = Color.Black,
            isText = false,
            txt = ""
        ) {
            val limit = currentTxt.length
            currentTxt = currentTxt.removeRange(limit - 1, limit)
        }

        Text(
            modifier = Modifier.constrainAs(txtResult) {
                bottom.linkTo(txtCalculation.top, margin = 20.dp)
                end.linkTo(parent.end)
            },
            text = resultTxt,
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            modifier = Modifier.constrainAs(txtCalculation) {
                bottom.linkTo(btnDivision.top, margin = 40.dp)
                end.linkTo(parent.end)
            },
            text = currentTxt,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
