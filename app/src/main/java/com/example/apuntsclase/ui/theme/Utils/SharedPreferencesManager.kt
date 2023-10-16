package com.example.apuntsclase.ui.theme.Utils

import android.content.Context
import android.content.SharedPreferences
import com.example.apuntsclase.ui.theme.MyApp

typealias Shared = SharedPreferencesManager

object SharedPreferencesManager {

    private  const val  MyPreferencesName = "MySharedPreferencesStorage"

    private val shared: SharedPreferences by lazy{ MyApp.Context.getSharedPreferences(
        MyPreferencesName, Context.MODE_PRIVATE)}
    private val editor: SharedPreferences.Editor by lazy{shared.edit()}

    private  const val  TimesOpenAppKey = "AppOpenTimes"
    public var TimeOpenApp: Int
        get() = shared.getInt(TimesOpenAppKey,0)
        set(value){
            editor.putInt(TimesOpenAppKey, value)
            editor.apply()
        }
}