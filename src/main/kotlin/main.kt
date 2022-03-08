package ru.netology

fun main() {

    val card = "VkPay"
    val transferAmount = 10_000_00
    val amountOfTransfersInCurrentMonth = 0

    validationCheck(card, transferAmount, amountOfTransfersInCurrentMonth)
}

private fun validationCheck(card: String, transferAmount: Int, amountOfTransfersInCurrentMonth: Int) {
    if (card == "VkPay" && (transferAmount > 15_000_00 || amountOfTransfersInCurrentMonth > 40_000_00)) {
        println("Перевод невозможен! Превышен лимит!")
    } else if (transferAmount < 150_000_00 && amountOfTransfersInCurrentMonth < 600_000_00) {
        val commission = calculateCommission(card, transferAmount, amountOfTransfersInCurrentMonth)
        println("Комиссия с вашего перевода составит: $commission коп.")
    } else {
        println("Перевод невозможен! Превышен лимит!")
    }
}

private fun calculateCommission(card: String, transferAmount: Int, amountOfTransfersInCurrentMonth: Int): Int =

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