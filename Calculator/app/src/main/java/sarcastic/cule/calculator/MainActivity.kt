package sarcastic.cule.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var result: EditText
    private lateinit var newNumber: EditText
    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.operation) }

    private var operand1: Double? = null
    private var operand2: Double = 0.0
    private var pendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result  = findViewById(R.id.result)
        newNumber  = findViewById(R.id.newNumber)
        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val buttonDecimal = findViewById<Button>(R.id.buttonDecimal)

        val buttonAdd       = findViewById<Button>(R.id.buttonAdd)
        val buttonMinus     = findViewById<Button>(R.id.buttonMinus)
        val buttonMultiply  = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide    = findViewById<Button>(R.id.buttonDivide)
        val buttonEqual     = findViewById<Button>(R.id.buttonEqual)

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
            displayOperation.text = pendingOperation
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
}
