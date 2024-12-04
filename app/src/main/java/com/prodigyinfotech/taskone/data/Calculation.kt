package com.prodigyinfotech.taskone.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

suspend fun calculate(str:String):Float {
    // the list of numbers without operations
    val listOfNum = mutableListOf<String>()
    // the list of operations
    val listOfOp = mutableListOf<Char>()
    // the result of the calculation operation
    var res = 0f
    // the new string to be used in calculation
    var newStr = str
    // formatting the new string of numbers and creating list of operations
    newStr.forEach { i ->
        if (i == '+' || i == 'x' || i == '-' || i == '/') {
            listOfOp.add(i)
            newStr = newStr.replace(i, '|')
        }
    }
    // creating list of numbers
    listOfNum.addAll(newStr.split('|'))
    // first calculating multiplication and division first
    for (i in 0 until listOfOp.size) {
        if (i >= listOfOp.size) {
            break
        }
        if (listOfOp[i] == 'x') {
            res = listOfNum[i].toFloat() * listOfNum[i + 1].toFloat()
            listOfNum.removeAt(i)
            listOfNum.removeAt(i)
            listOfNum.add(i, res.toString())
            listOfOp.removeAt(i)
        } else if (listOfOp[i] == '/') {
            res = listOfNum[i].toFloat() / listOfNum[i + 1].toFloat()
            listOfNum.removeAt(i)
            listOfNum.removeAt(i)
            listOfNum.add(i, res.toString())
            listOfOp.removeAt(i)
        }

    }
    // then calculating the addition and the subtraction
    while (listOfOp.isNotEmpty()) {
        val index = 0
        if (listOfOp[index] == '+') {
            res = listOfNum[index].toFloat() + listOfNum[index + 1].toFloat()
            listOfNum.removeAt(index)
            listOfNum.removeAt(index)
            listOfNum.add(index, res.toString())
            listOfOp.removeAt(index)
        } else if (listOfOp[index] == '-') {
            res = listOfNum[index].toFloat() - listOfNum[index + 1].toFloat()
            listOfNum.removeAt(index)
            listOfNum.removeAt(index)
            listOfNum.add(index, res.toString())
            listOfOp.removeAt(index)
        }
    }
    // returning the result with coroutines with time out of 2 seconds
    return withTimeout(2000){
        withContext(Dispatchers.IO){ res }
    }
}