package com.rc.android.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.math.roundToInt

class SqrActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_COUNT = "EXTRA_DATA_FOR_SQR_ACTIVITY"
        private val LOG_TAG = "SQR_ACTIVITY_LOG"
    }

    private var count: Int = 0
        set(value) {
            val numberTextView2: TextView = findViewById(R.id.numberTextView2)

            numberTextView2?.let {
                field = value
                it.text = "$value"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqr)

        Log.i(LOG_TAG, "onCreate")

        val count = intent.extras?.getInt(EXTRA_DATA_COUNT) ?: 0

        this.count = Math.pow(count.toDouble(), 2.0).roundToInt()
    }

    override fun onStart() {
        super.onStart()
        Log.i(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOG_TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(LOG_TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_TAG, "onDestroy")
    }
}