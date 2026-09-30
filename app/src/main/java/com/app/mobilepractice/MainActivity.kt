package com.app.mobilepractice

import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var edtText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtText = findViewById(R.id.edtText)

        // 키가 눌릴 때마다 바뀐 글자를 토스트로 출력
        edtText.setOnKeyListener { view, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP) {
                Toast.makeText(applicationContext, edtText.text.toString(), Toast.LENGTH_SHORT).show()
            }
            false
        }
    }
}
