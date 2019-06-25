package sarcastic.cule.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException


private const val PENDING_OPERATION = "PendingOperation"
private const val RESULT = "Result"
private const val NEW_NUMBER = "NewNumber"

class MainActivity : AppCompatActivity() {

    private var operand1: Double? = null
    private var operand2: Double = 0.0
    private var pendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener  = View.OnClickListener { view->
            val b = view as Button
            newNumber.append(b.text)
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDecimal.setOnClickListener(listener)

        val opListener = View.OnClickListener { v->
            val op = (v as Button).text.toString()

            try {
                val value  = newNumber.text.toString().toDouble()
                performOperation(op, value)
            } catch (e: NumberFormatException){
                newNumber.setText("")
            }
            pendingOperation = op
            operation.text = pendingOperation
        }

        buttonNeg.setOnClickListener {
            val value = newNumber.text.toString()
            if(value.isEmpty()){
                newNumber.setText("-")
            }else{
                try {
                    val doubleValue = value.toDouble() * -1
                    newNumber.setText(doubleValue.toString())
                } catch (e: NumberFormatException){
                    newNumber.setText("")
                }
            }
        }

        buttonAdd     .setOnClickListener(opListener)
        buttonMinus   .setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonDivide  .setOnClickListener(opListener)
        buttonEqual   .setOnClickListener(opListener)
    }

    private fun performOperation(op: String, value: Double) {
        if(operand1 == null){
            operand1 = value
        }else{
            operand2 = value

            if(pendingOperation == "="){
                pendingOperation = op
            }

            when(pendingOperation){
                "="-> operand1 = operand2

                "+"-> operand1 = operand1!! + operand2

                "-"-> operand1 = operand1!! - operand2

                "/"-> operand1 = if(operand2 == 0.0){
                    Double.NaN
                }else{
                    operand1!! / operand2
                }

                "*"-> operand1 = operand1!! * operand2
            }
        }

        result.setText(operand1.toString())
        newNumber.setText("")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putString(PENDING_OPERATION, pendingOperation)
        if(result.text!=null) {
            outState?.putString(RESULT, result.text.toString())
        }
        if(newNumber.text!=null) {
            outState?.putString(NEW_NUMBER, newNumber.text.toString())
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState!=null){
            pendingOperation = savedInstanceState.getString(PENDING_OPERATION)!!
            operation.text = pendingOperation
            if(savedInstanceState.getString(RESULT)!=null) {
                result.setText(savedInstanceState.getString(RESULT)!!)
                operand1 = savedInstanceState.getString(RESULT)!!.toDouble()
            }else{
                operand1 = null
            }
            if (savedInstanceState.getString(NEW_NUMBER)!=null) {
                newNumber.setText(savedInstanceState.getString(NEW_NUMBER)!!)
            }
        }
    }
}
