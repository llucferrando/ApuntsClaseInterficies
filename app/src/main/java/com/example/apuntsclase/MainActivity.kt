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
    val result: TextView by lazy { findViewById(R.id.result) }
    val bContainer: LinearLayout by lazy{findViewById(R.id.buttons_container)}
    enum class Operation(val operation:(a:Int, b:Int)->Int, val char: String){
        Add({a,b->a + b}, " + "),
        Substract({a,b-> a - b}, " - "),
        Multiply({a,b-> a * b}, " * "),
        Divide({a,b-> a / b}, " / ");

        public fun Operate(a:Int, b:Int): Int{
            return this.operation(a,b);
        }
    }

    var A:Int? = null
    var B:Int? = null
    var Op:Operation?=null
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)


        val buttonGrid = ButtonGrid(this,bContainer)

        var names: MutableList<MutableList<String>> = mutableListOf()
        names.add(mutableListOf("AC", "()","%","/"))
        names.add(mutableListOf("7", "8","9","X"))
        names.add(mutableListOf("4", "5","6","-"))
        names.add(mutableListOf("1", "2","3","+"))
        names.add(mutableListOf("0", ".","<-","="))
        for(y in names.indices){
            val row =  buttonGrid.AddNewRow()
            for(x in names[y].indices){
                val _bt = row.AddNewButton(names[y][x])
                _bt.setOnClickListener{
                    when(names[x][y]){
                        "AC"->{
                            A = null
                            B = null
                            Op = null
                            result.text = "0"
                        }
                        "0","1","2","3","4","5","6","7","8","9"->{
                          NumberPress(names[x][y].toInt())
                            "+" ->{
                                OperationPress(Operation.Add)
                            }
                            "-" ->{
                                OperationPress(Operation.Substract)
                            }
                            "*" ->{
                                OperationPress(Operation.Multiply)
                            }
                            "/" ->{
                                OperationPress(Operation.Divide)
                            }
                            "=" ->{
                               A?.let{a->
                                   B?.let{b->
                                       val resultNum
                                   }
                               }
                            }
                        }

                    }
                }

            }
        }
    }
    fun NumberPress(num:Int){
        if(Op==null){
            A?.let{ a->
                A = (a*10) + num
            } ?: run{
                A=num
            }
            result.text=A.toString()
        }else{
            B?.let{ b->
                B = (b*10) + num
            } ?: run{
                B=num
            }

            result.text = A.toString() + Op.toString() + B.toString()
        }
    }
    fun OperationPress(op:Operation){
        if(A!=null && B==null) {
            Op = op
            result.text = A.toString() + Op?.char
        }
    }

}


