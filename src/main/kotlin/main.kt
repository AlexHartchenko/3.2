package ru.netology

fun main() {

    val card = "Maestro"
    val transferAmount = 100_00
    val amountOfTransfersInCurrentMonth = 0

    println(validationCheck(card, transferAmount, amountOfTransfersInCurrentMonth))
}

fun validationCheck(card: String, transferAmount: Int, amountOfTransfersInCurrentMonth: Int): String {
    return if (card == "VkPay" && (transferAmount > 15_000_00 || amountOfTransfersInCurrentMonth > 40_000_00)) {
       "Перевод невозможен! Превышен лимит!"
    } else if (transferAmount < 150_000_00 && amountOfTransfersInCurrentMonth < 600_000_00) {
        val commission = calculateCommission(card, transferAmount, amountOfTransfersInCurrentMonth)
        "Комиссия с вашего перевода составит: $commission коп."
    } else {
        "Перевод невозможен! Превышен лимит!"
    }
}

fun calculateCommission(card: String, transferAmount: Int, amountOfTransfersInCurrentMonth: Int): Int =

    when (card) {
        "VkPay" -> 0
        "Mastercard", "Maestro" -> {
            if (transferAmount > 300_00 && amountOfTransfersInCurrentMonth <= 75_000_00) 0 else ((transferAmount * 0.06) + 20_00).toInt()
        }
        "Visa", "Mir" -> {
            if (((transferAmount * 0.075).toInt() <= 35_00)) 35_00 else ((transferAmount * 0.075).toInt())
        }
        else -> 0
    }