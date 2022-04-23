fun main() {
    val amount = 850_000
    val comissionRate = 0.0075
    val comissionMinimum = 3500

    val transferComission = if ((amount * comissionRate) < comissionMinimum) comissionMinimum else
        (amount * comissionRate).toInt()

    val kopecks = transferComission % 100

    println("Сумма перевода: " + amount / 100 + " руб.")
    println("Комиссия за перевод составит: " + transferComission / 100 + " руб. $kopecks коп.")




}