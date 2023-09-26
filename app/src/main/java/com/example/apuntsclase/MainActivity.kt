package com.example.apuntsclase

import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
    var counter = 0;

    val text: TextView by lazy { findViewById(R.id.start_screen_text) }
    val button: TextView by lazy { findViewById(R.id.start_screen_button) }
    val editText: TextView by lazy { findViewById(R.id.edit_text) }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)



        button.setOnClickListener{
            counter++
            text.text = counter.toString()
        }


    }

}


