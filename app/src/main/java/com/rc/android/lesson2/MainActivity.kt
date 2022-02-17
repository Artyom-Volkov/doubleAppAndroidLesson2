package com.rc.android.lesson2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val COUNT_STATE = "COUNT_STATE_EXTRA"
        private val LOG_TAG = "MAIN_ACTIVITY_LOG"
    }

    private var count: Int = 0
        set(value) {
            val numberTextView1: TextView = findViewById(R.id.numberTextView1)

            numberTextView1?.let {
                field = value
                it.text = "$value"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(LOG_TAG, "onCreate")

        val button: Button = findViewById(R.id.sqr_btn)
        button.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                SqrActivity::class.java
            ).apply {
                val bundle = Bundle().apply { putInt( SqrActivity.EXTRA_DATA_COUNT, count) }
                putExtras(bundle)
            }

            startActivity(intent)
        }

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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNT_STATE, count)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt(COUNT_STATE) + 1
        super.onRestoreInstanceState(savedInstanceState)
    }


}