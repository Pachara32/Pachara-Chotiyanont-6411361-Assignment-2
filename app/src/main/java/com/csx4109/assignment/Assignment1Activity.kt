package com.csx4109.assignment

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression


/**
 * Page Name: Basic Calculator
 *
 * -- Description --
 * Create an app can do basic calculation, consists of
 * - textView named `tvResult`
 * - button of number 0-9 named `btn0` - `btn9`
 * - button named `btnPlus`
 * - button named `btnEqual`
 * - button named `btnClear`
 *
 * Cases
 * - When open an application, the first value in `tvResult` should be 0
 * - When type any number button and `btnPlus`, value on `tvResult` should be updated
 * - When click `btnEqual`, value on `tvResult` should updated to be the result of your calculation
 * - After click `btnEqual` to calculate the result, you should be able to type more number for further calculation
 * - When click `btnClear`, value on `tvResult` should return to 0
 */
class Assignment1Activity : AppCompatActivity() {
    private lateinit var display: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment1)

        display = findViewById(R.id.tvResult)
        display.showSoftInputOnFocus = false
        display.setOnClickListener {
            if (getString(R.string.tvResult) == display.text.toString()) {
                display.setText("")
            }
        }
    }

    private fun updateText(strToAdd: String) {
        val oldStr = display.text.toString()
        val cursorPos = display.selectionStart
        val leftStr = oldStr.substring(0, cursorPos)
        val rightStr = oldStr.substring(cursorPos)

        if (getString(R.string.tvResult) == display.text.toString()) {
            display.setText(strToAdd)
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr))
            display.setSelection(cursorPos + 1)
        }
    }

    fun zeroBTN(view: View) {
        updateText("0")
    }

    fun oneBTN(view: View) {
        updateText("1")
    }

    fun twoBTN(view: View) {
        updateText("2")
    }

    fun threeBTN(view: View) {
        updateText("3")
    }

    fun fourBTN(view: View) {
        updateText("4")
    }

    fun fiveBTN(view: View) {
        updateText("5")
    }

    fun sixBTN(view: View) {
        updateText("6")
    }

    fun sevenBTN(view: View) {
        updateText("7")
    }

    fun eightBTN(view: View) {
        updateText("8")
    }

    fun nineBTN(view: View) {
        updateText("9")
    }

    fun clearBTN(view: View) {
        display.setText("")
    }

    fun parenthesesBTN(view: View) {
        val cursorPos = display.selectionStart
        var openPar = 0
        var closePar = 0
        val textLen = display.text.length

        for (i in 0 until cursorPos) {
            if (display.text.toString().substring(i, i + 1) == "(") {
                openPar += 1
            }
            if (display.text.toString().substring(i, i + 1) == ")") {
                closePar += 1
            }
        }

        if (openPar == closePar || display.text.toString().substring(textLen - 1, textLen) == "(") {
            updateText("(")
            display.setSelection(cursorPos + 1)
        } else if (closePar < openPar && !display.text.toString().substring(textLen - 1, textLen).equals("(")) {
            updateText(")")
        }

        display.setSelection(cursorPos + 1)
    }


    fun exponentBTN(view: View) {
        updateText("^")
    }

    fun divideBTN(view: View) {
        updateText("÷")
    }

    fun multiplyBTN(view: View) {
        updateText("×")
    }

    fun subtractBTN(view: View) {
        updateText("-")
    }

    fun addBTN(view: View) {
        updateText("+")
    }

    fun equalsBTN(view: View?) {
        var userExp = display.text.toString()
        userExp = userExp.replace("÷".toRegex(), "/")
        userExp = userExp.replace("×".toRegex(), "*")
        val exp = Expression(userExp)
        val result = exp.calculate().toString()
        display.setText(result)
        display.setSelection(result.length)
    }


    fun pointBTN(view: View) {
        updateText(".")
    }

    fun plusMinusBTN(view: View) {
        updateText("-")
    }

    fun backspace(view: View) {
        val cursorPos = display.selectionStart
        val textLen = display.text.length

        if (cursorPos != 0 && textLen != 0) {
            val selection = display.text as SpannableStringBuilder
            selection.replace(cursorPos - 1, cursorPos, "")
            display.text = selection
            display.setSelection(cursorPos - 1)
        }
    }

}