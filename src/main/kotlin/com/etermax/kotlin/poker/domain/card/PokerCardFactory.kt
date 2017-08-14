package com.etermax.kotlin.poker.domain.card

class PokerCardFactory {
    fun createFrom(cardString: String): PokerCard {
        //"23456789TJQKA".indexOf(cardString[0])
        return PokerCard(cardString[0].toString(), PokerCard.Suit.findByCharacter(cardString[1]))
    }

}