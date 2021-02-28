import kotlin.math.*

fun main(args: Array<String>) {
    var run:Boolean = true
    do {
        menu()
        print("Informe a opção desejada: ")
        var option:Int = readLine()!!.toInt()
        var num1:Float
        var num2:Float
        when(option){
            1 -> {
                num1 = getNumber("Informe o primeiro número: ")
                num2 = getNumber("Informe o segundo número: ")
                println("O resultado da soma é: ${sum(num1, num2)}")
            }
            2 -> {
                num1 = getNumber("Informe o primeiro número: ")
                num2 = getNumber("Informe o segundo número: ")
                println("O resultado da soma é: ${subtraction(num1, num2)}")
            }
            3 -> {
                num1 = getNumber("Informe o primeiro número: ")
                num2 = getNumber("Informe o segundo número: ")
                println("O resultado da soma é: ${multiplication(num1, num2)}")
            }
            4 -> {
                num1 = getNumber("Informe o dividendo: ")
                num2 = getNumber("Informe o divisor: ")
                println("O resultado da soma é: ${division(num1, num2)}")
            }
            5 -> {
                num1 = getNumber("Informe o dividendo: ")
                num2 = getNumber("Informe o divisor: ")
                println("O resultado da soma é: ${mod(num1, num2)}")
            }
            6 -> {
                num1 = getNumber("Informe a base: ")
                num2 = getNumber("Informe a potência: ")
                println("O resultado da soma é: ${power(num1, num2)}")
            }
            7 -> {
                num1 = getNumber("Informe o logaritmando: ")
                num2 = getNumber("Informe a base: ")
                println("O resultado da soma é: ${log(num1, num2)}")
            }
            8 -> {
                num1 = getNumber("Informe o primeiro número: ")
                num2 = getNumber("Informe o segundo número: ")
                println("O resultado da soma é: ${average(num1, num2)}")
            }
            9 -> {
                run = false
            }
            else -> println("Opção Inválida!!\n")
        }

    }while(run)
}

fun getNumber(msg: String): Float {
    print(msg)
    return readLine()!!.toFloat()
}

fun menu(){
    println("\nBem vindo a calculadora!\n")
    println("Em todas as funções necessitam colocar dois números\n")
    println("Selecione uma das opções abaixo:\n")
    println("1 - Soma       2 - Substração  3 - Multiplicação ")
    println("4 - Divisão    5 - Resto       6 - Potência")
    println("7 - Logaritmo  8 - Média       9 - Sair\n\n")

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

fun average(m: Float, n: Float):Float = division(sum(m, n),2.0f)

fun log(m: Float, n: Float):Float {
    require(m > 0f){"Valor de M fora do range permitido"}
    require(n > 1f){"Valor de N fora do range permitido"}

    var logarithming:Float = m
    var base:Float = n
    var res:Float = 0f
    while (logarithming >= base){
        logarithming = division(logarithming, base)
        res = sum(res,1f)
    }

    if (logarithming != 1f){
        var coef:Float = 0.5f
        var divisionCoef:Float = 0f

        while(logarithming != 1f){
            base = sqrt(base);

            if (logarithming >= base){
                logarithming = division(logarithming, base)
                coef = division(coef, power(2f, divisionCoef))
                res = sum(res, coef)

                divisionCoef = 0f
            }

            divisionCoef = sum(divisionCoef, 1f)
        }
    }
    return res
}