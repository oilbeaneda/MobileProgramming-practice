package com.app.mobilepractice.week5_practice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.mobilepractice.R
import kotlin.math.pow

class CalculatorActivity : AppCompatActivity() {
    lateinit var edit1: EditText
    lateinit var edit2: EditText
    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button
    lateinit var btnPow: Button
    lateinit var btnClear: Button
    lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        title = getString(R.string.calc_title)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calcMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)
        btnPow = findViewById(R.id.btnPow)
        btnClear = findViewById(R.id.btnClear)
        textResult = findViewById(R.id.textResult)

        btnAdd.setOnClickListener { calculate { a, b -> a + b } }
        btnSub.setOnClickListener { calculate { a, b -> a - b } }
        btnMul.setOnClickListener { calculate { a, b -> a * b } }
        btnDiv.setOnClickListener {
            if (edit2.text.toString().toDoubleOrNull() == 0.0) {
                Toast.makeText(applicationContext, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show()
            } else {
                calculate { a, b -> a / b }
            }
        }

        // 1) 거듭제곱 버튼: x^y 계산
        btnPow.setOnClickListener { calculate { a, b -> a.pow(b) } }

        // 2) C 버튼: 에디트텍스트를 0으로 초기화
        btnClear.setOnClickListener {
            edit1.setText("0")
            edit2.setText("0")
            textResult.text = getString(R.string.calc_result)
        }
    }

    private fun calculate(op: (Double, Double) -> Double) {
        val num1 = edit1.text.toString().toDoubleOrNull()
        val num2 = edit2.text.toString().toDoubleOrNull()
        if (num1 == null || num2 == null) {
            Toast.makeText(applicationContext, "숫자를 입력하세요", Toast.LENGTH_SHORT).show()
            return
        }
        val result = op(num1, num2)
        // 정수로 떨어지면 소수점 없이 출력 (예: 32.0 → 32)
        val resultText = if (result % 1 == 0.0) result.toLong().toString() else result.toString()
        textResult.text = getString(R.string.calc_result) + resultText
    }
}
