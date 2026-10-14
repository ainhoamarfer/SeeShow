package com.ainhoamarfer.seriesee

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            TextView(this).apply {
                text = getString(R.string.app_name)
                textSize = 24f
                gravity = Gravity.CENTER
            }
        )
    }
}