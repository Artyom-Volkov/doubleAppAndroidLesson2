package com.rc.android.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val COUNT_STATE = "COUNT_STATE_EXTRA"
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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNT_STATE, count)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt(COUNT_STATE) + 1
        super.onRestoreInstanceState(savedInstanceState)
    }


}