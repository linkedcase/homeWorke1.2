const val ITEM_PRICE = 100_00U
const val MINIMAL_DISCOUNT = 100_00U
const val MAX_DISCOUNT = 5U
const val EXTRA_DISCOUNT = 1U
const val START_MAX_DISCOUNT = 10_000_00U
const val START_MINIMAL_DISCOUNT = 1_000_00U
const val MUSIC_LOVER = true
var newTotalPrice: UInt = 0U
var kopecks = 0U
var itemCount: UInt = 0U

fun main() {
    println("Стоимость одного музыкального трэка 100 руб.")

    while (true) {
        print("Введи количество выбранных трэков. Для завершения покупки введи: 0 ")
        val input = readLine()?.toUInt() ?: return
        if (input == 0U) break else itemCount += input
    }

    val totalPrice = itemCount * ITEM_PRICE

    if (totalPrice > START_MAX_DISCOUNT) {
        newTotalPrice = totalPrice - ((totalPrice * MAX_DISCOUNT) / 100U)
        kopecks = totalPrice % 100U
    } else if (totalPrice > START_MINIMAL_DISCOUNT || totalPrice <= START_MAX_DISCOUNT) {
        newTotalPrice = (totalPrice - MINIMAL_DISCOUNT)
        kopecks = totalPrice % 100U
    } else {
        newTotalPrice = totalPrice
    }

    val additionalDiscount: UInt

    println("Вы заказали музыку на сумму ${totalPrice / 100U} руб. $kopecks коп.")
    println("Ваша скидка составила ${(totalPrice - newTotalPrice) / 100U} руб. $kopecks коп.")
    println("Сумма заказа с учётом скидки: ${newTotalPrice / 100U} руб. $kopecks коп.")

    if (MUSIC_LOVER) {
        additionalDiscount = (newTotalPrice * EXTRA_DISCOUNT) / 100U
        newTotalPrice -= additionalDiscount
        kopecks += additionalDiscount % 100U
        println("Дополнительная скидка постоянного пользователя (1%): " +
                "${additionalDiscount / 100U} руб. $kopecks коп.")
        println("Итого к оплате: ${newTotalPrice / 100U} руб. $kopecks коп.")
    } else {
        println("Дополнительная скидка постоянного пользователя (1%) не действует")
    }
}