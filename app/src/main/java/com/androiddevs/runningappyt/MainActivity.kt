package com.androiddevs.runningappyt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var KEY = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KEY =  resources.getString(R.string.google_maps_key)
        Log.i(TAG, KEY )
    }
}
