package com.app.mobilepractice.hw2

// [예제 3-7] Car 클래스
open class Car {
    var color: String = ""
    var speed: Int = 0

    companion object {
        var carCount: Int = 0
        const val MAXSPEED: Int = 200
        const val MINSPEED: Int = 0
        fun currentCarCount(): Int {
            return carCount
        }
    }

    constructor(color: String, speed: Int) {
        this.color = color
        this.speed = speed
        carCount++
    }

    constructor(speed: Int) {
        this.speed = speed
    }

    constructor()

    open fun upSpeed(value: Int) {
        if (speed + value >= MAXSPEED)
            speed = MAXSPEED
        else
            speed += value
    }

    fun downSpeed(value: Int) {
        if (speed - value <= MINSPEED)
            speed = MINSPEED
        else
            speed -= value
    }
}

// Car 클래스를 상속받은 Truck 클래스
class Truck : Car {
    var cc: Int = 0  // 배기량

    companion object {
        const val YEAR: Int = 2023  // 생산 연도
    }

    // 배기량 값을 파라미터로 받는 생성자
    constructor(cc: Int) : super() {
        this.cc = cc
    }

    constructor(color: String, speed: Int, cc: Int) : super(color, speed) {
        this.cc = cc
    }

    // 최대 속도 150으로 오버라이딩
    override fun upSpeed(value: Int) {
        if (speed + value >= 150)
            speed = 150
        else
            speed += value
    }
}

fun main() {
    val truck1 = Truck("파랑", 0, 5000)
    val truck2 = Truck(8000)

    truck1.upSpeed(100)
    println("트럭1: 색상=${truck1.color}, 배기량=${truck1.cc}cc, 생산연도=${Truck.YEAR}, 속도=${truck1.speed}")
    truck1.upSpeed(100)
    println("트럭1: 100 가속 → 속도=${truck1.speed} (최대 150)")

    truck2.upSpeed(200)
    println("트럭2: 배기량=${truck2.cc}cc, 생산연도=${Truck.YEAR}, 200 가속 → 속도=${truck2.speed}")
    truck2.downSpeed(50)
    println("트럭2: 50 감속 → 속도=${truck2.speed}")
}
