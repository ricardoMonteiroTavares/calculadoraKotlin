import kotlin.math.*

fun main(args: Array<String>) {
}

fun sum(m: Float, n: Float):Float = m.plus(n)

fun subtraction(m: Float, n: Float):Float = m.minus(n)

fun multiplication(m: Float, n: Float):Float = m.times(n)

fun division(m: Float, n: Float):Float = m.div(n)

fun mod(m: Float, n: Float):Float = m.rem(n)

fun power(m: Float, n: Float):Float {
    if (n == 0f) return 1f

    var base:Float = m
    val inverter:Float = -1f

    if (m < 0) return multiplication(multiplication(base, inverter).pow(n), inverter)
    return m.pow(n)
}
