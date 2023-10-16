package com.example.apuntsclase

import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.widget.doBeforeTextChanged
import com.example.apuntsclase.ui.theme.ApuntsClaseTheme

class MainActivity : ComponentActivity() {

    val result: TextView by lazy { findViewById(R.id.result)}
    val btContainer: LinearLayout by lazy { findViewById(R.id.buttons_container) }

    enum class Operation(private val operation: (a: Int, b:Int) -> Int, val char: String) {
        Add({a,b -> a + b}, " + "),
        Sub({a,b -> a - b}, " - "),
        Mul({a,b -> a * b}, " X "),
        Div({a,b -> a / b}, " / ");

        public fun Operate(a:Int, b:Int) : Int {
            return this.operation(a,b)
        }
    }

    var A:Int? = null
    var B:Int? = null
    var Op:Operation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        val buttonsGrid = ButtonGrid(this, btContainer)

        var names: MutableList<MutableList<String>> = mutableListOf()
        names.add(mutableListOf("AC", "()", "%", "/"))
        names.add(mutableListOf("7", "8", "9", "X"))
        names.add(mutableListOf("4", "5", "6", "-"))
        names.add(mutableListOf("1", "2", "3", "+"))
        names.add(mutableListOf("0", ".", "<-", "="))

        for (y in names.indices) {
            val row = buttonsGrid.AddNewRow()

            for (x in names[y].indices) {
                val bt = row.AddNewButton(names[y][x])

                bt.setOnClickListener {
                    when(names[y][x]) {
                        "AC" -> {
                            A = null
                            B = null
                            Op = null
                            result.text = "0"
                        }
                        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                            NumberPress(names[y][x].toInt())
                        }
                        "+" -> {
                            OperationPress(Operation.Add)
                        }
                        "-" -> {
                            OperationPress(Operation.Sub)
                        }
                        "X" -> {
                            OperationPress(Operation.Mul)
                        }
                        "/" -> {
                            OperationPress(Operation.Div)
                        }
                        "=" -> {
                            A?.let { a ->
                                B?.let { b ->
                                    val resultNum = Op?.Operate(a,b)
                                    result.text = resultNum.toString()
                                    A = resultNum
                                    B = null
                                    Op = null
                                }
                            }
                        }
                    }
                }

            }
        }

    }

    fun NumberPress(num:Int) {
        if(Op == null) {
            //Cosas de A
            A?.let { a ->
                A = (a * 10) + num
            } ?: run {
                A = num
            }

            result.text = A.toString()
        } else {
            //Cosas de B
            B?.let { b ->
                B = (b * 10) + num
            } ?: run {
                B = num
            }

            result.text = A.toString() + Op?.char + B.toString()
        }
    }

    fun OperationPress(op: Operation) {
        if(A != null && B == null) {
            Op = op
            result.text = A.toString() + Op?.char
        }
    }
}


