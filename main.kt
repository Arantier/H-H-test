import kotlin.random.Random

//Простой вариант
fun findMaxNumber(array: Array<Int>) = if (!array.isNullOrEmpty()) array.indexOf(array.max()!!) else -1

fun searchTest(numberOfTests: Int) {
    //Тест случайными значениями
    var testsPassed = 0
    for (i in 1..numberOfTests) {
        val maxSize = Random.nextInt(100)
        val maxNumber = Random.nextInt()
        val numberSequence = Array(maxSize) { Random.nextInt(Int.MIN_VALUE, maxNumber) }
        var position: Int
        if (maxSize != 0) {
            position = Random.nextInt(maxSize)
            numberSequence[position] = maxNumber
        } else {
            position = -1
        }

        if (findMaxNumber(numberSequence) == position) {
            testsPassed++
        }
    }
    print("Random values testing: %s: $testsPassed/$numberOfTests\n".format(if (testsPassed == numberOfTests) "passed" else "failed"))

    //Тестирование одинаковыми значениями
    testsPassed = 0
    for (i in 1..numberOfTests) {
        val maxSize = Random.nextInt(100)
        val maxNumber = Random.nextInt()
        val numberSequence = Array(maxSize) { maxNumber }
        var position = if (maxSize != 0) 0 else -1

        if (findMaxNumber(numberSequence) == position) {
            testsPassed++
        }
    }
    print("Identical values testing: %s: $testsPassed/$numberOfTests\n".format(if (testsPassed == numberOfTests) "passed" else "failed"))

}

fun main(args: Array<String>) {
    // Кстати, это моё второе тестовое задание вам!
    // Прошлое было для курса Андроида и написано на Яве, я там принимал массив из файла и
    // я выпендривался кривой многопоточкой. В принципе можете на него тоже взглянуть коммитом раньше,
    // но он нынешним условиям задачи не соответствует.
    searchTest(1000000)
}