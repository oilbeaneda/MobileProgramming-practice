package com.app.mobilepractice.week4_practice

// 퀴즈1 - 1번: when 식으로 학점 계산
fun main() {
    val calculateGrade: (Int) -> String = { score ->
        // score 값의 범위를 판별하여 학점을 반환
        when (score) {
            in 90..100 -> "A"
            in 80..89 -> "B"
            in 70..79 -> "C"
            else -> "F"
        }
    }
    println(calculateGrade(85)) // 출력: B
}
