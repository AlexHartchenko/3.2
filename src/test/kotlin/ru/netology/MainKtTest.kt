package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun validationCheck_Vk() {
        //arrange
        val card = "VkPay"
        val amount = 16_000_00
        val amountInCurrentMonth = 0
        //act
        val result = ru.netology.validationCheck(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals("Перевод невозможен! Превышен лимит!", result)
    }
    @Test
    fun validationCheck_Vk_Good() {
        //arrange
        val card = "VkPay"
        val amount = 10_000_00
        val amountInCurrentMonth = 0
        val commission = ru.netology.calculateCommission(card, amount, amountInCurrentMonth)
        //act
        val result = ru.netology.validationCheck(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals("Комиссия с вашего перевода составит: $commission коп.", result)
    }
    @Test
    fun validationCheck_Vk_Month() {
        //arrange
        val card = "VkPay"
        val amount = 10_000_00
        val amountInCurrentMonth = 1_000_000_00
        //act
        val result = ru.netology.validationCheck(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals("Перевод невозможен! Превышен лимит!", result)
    }

    @Test
    fun validationCheck_Visa() {
        //arrange
        val card = "Visa"
        val amount = 16_000_00
        val amountInCurrentMonth = 0
        val commission = ru.netology.calculateCommission(card, amount, amountInCurrentMonth)

        //act
        val result = ru.netology.validationCheck(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals("Комиссия с вашего перевода составит: $commission коп.", result)
    }

    @Test
    fun validationCheck_Mir() {
        //arrange
        val card = "Mir"
        val amount = 16_000_00
        val amountInCurrentMonth = 0
        val commission = ru.netology.calculateCommission(card, amount, amountInCurrentMonth)

        //act
        val result = ru.netology.validationCheck(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals("Комиссия с вашего перевода составит: $commission коп.", result)
    }

    @Test
    fun validationCheck_Mastercard() {
        //arrange
        val card = "Mastercard"
        val amount = 16_000_00
        val amountInCurrentMonth = 0
        val commission = ru.netology.calculateCommission(card, amount, amountInCurrentMonth)

        //act
        val result = ru.netology.validationCheck(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals("Комиссия с вашего перевода составит: $commission коп.", result)
    }

    @Test
    fun validationCheck_Maestro() {
        //arrange
        val card = "Maestro"
        val amount = 16_000_00
        val amountInCurrentMonth = 0
        val commission = ru.netology.calculateCommission(card, amount, amountInCurrentMonth)

        //act
        val result = ru.netology.validationCheck(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals("Комиссия с вашего перевода составит: $commission коп.", result)
    }

    @Test
    fun calculateCommission_Vk() {
        //arrange
        val card = "VkPay"
        val amount = 10_000_00
        val amountInCurrentMonth = 0
        //act
        val result = ru.netology.calculateCommission(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals(0, result)
    }
    @Test
    fun calculateCommission_Mir() {
        //arrange
        val card = "Mir"
        val amount = 10_000_00
        val amountInCurrentMonth = 0
        //act
        val result = ru.netology.calculateCommission(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals(75000, result)
    }
    @Test
    fun calculateCommission_Visa() {
        //arrange
        val card = "Visa"
        val amount = 100_000_00
        val amountInCurrentMonth = 0
        //act
        val result = ru.netology.calculateCommission(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals(750000, result)
    }
    @Test
    fun calculateCommission_Maestro() {
        //arrange
        val card = "Maestro"
        val amount = 100_000_00
        val amountInCurrentMonth = 0
        //act
        val result = ru.netology.calculateCommission(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals(0, result)
    }
    @Test
    fun calculateCommission_Maestro_Month() {
        //arrange
        val card = "Maestro"
        val amount = 100_000_00
        val amountInCurrentMonth = 100_000_00
        //act
        val result = ru.netology.calculateCommission(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals(602000, result)
    }
    @Test
    fun calculateCommission_Mastercard_Minimum() {
        //arrange
        val card = "Mastercard"
        val amount = 300_00
        val amountInCurrentMonth = 0
        //act
        val result = ru.netology.calculateCommission(
            card = card,
            transferAmount = amount,
            amountOfTransfersInCurrentMonth = amountInCurrentMonth
        )
        //assert
        assertEquals(3800, result)
    }
}