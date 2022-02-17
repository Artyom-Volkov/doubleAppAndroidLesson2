package com.rc.android.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.roundToInt

class SqrActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_COUNT = "EXTRA_DATA_FOR_SQR_ACTIVITY"
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

        val count = intent.extras?.getInt(EXTRA_DATA_COUNT) ?: 0

        this.count = Math.pow(count.toDouble(), 2.0).roundToInt()
    }
}