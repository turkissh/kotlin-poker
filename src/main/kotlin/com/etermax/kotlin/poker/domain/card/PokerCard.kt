package com.etermax.kotlin.poker.domain.card

import com.sun.javaws.exceptions.InvalidArgumentException

class PokerCard(val number: String, val suit: Suit) {

    fun getCardValue() =
            when (number) {
                "2" -> 2
                "3" -> 3
                "4" -> 4
                "5" -> 5
                "6" -> 6
                "7" -> 7
                "8" -> 8
                "9" -> 9
                "T" -> 10
                "J" -> 11
                "Q" -> 12
                "K" -> 13
                "A" -> 14
                else -> {
                    throw InvalidArgumentException(arrayOf("invalid card number $(number)"))
                }
            }

    enum class Suit(val character: String) {
        SPIKE("S"), HEART("H"), CLUB("C"), DIAMOND("D");

        companion object {
            fun findByCharacter(character: Char): Suit {
                return Suit.values().find { it.character[0] == character } ?: throw RuntimeException("Invalid card suit")
            }
        }
    }

}