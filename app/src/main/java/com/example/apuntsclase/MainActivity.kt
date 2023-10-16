package com.example.apuntsclase

import android.content.Context
import android.content.SharedPreferences
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
import com.example.apuntsclase.ui.theme.Utils.Shared
import com.example.apuntsclase.ui.theme.Utils.SharedPreferencesManager

class MainActivity : ComponentActivity() {
    val openTimesAppNext by lazy {findViewById<TextView>(R.id.open_app_times_text)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)
        Shared.TimeOpenApp

    }
}


