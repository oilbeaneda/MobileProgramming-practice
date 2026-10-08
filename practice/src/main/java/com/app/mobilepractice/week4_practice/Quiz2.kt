package com.app.mobilepractice.week4_practice

// 퀴즈1 - 2번: open / override

// 부모 클래스 선언
open class Animal {
    // 자식 클래스에서 재정의 허용
    open fun makeSound() {
        println("동물 소리")
    }
}

class Dog : Animal() {
    // 부모 메서드 재정의
    override fun makeSound() {
        println("멍멍")
    }
}

fun main() {
    val myDog = Dog()
    myDog.makeSound() // 출력: 멍멍
}
