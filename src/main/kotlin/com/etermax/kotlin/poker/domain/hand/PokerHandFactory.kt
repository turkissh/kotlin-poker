package com.etermax.kotlin.poker.domain.hand

import com.etermax.kotlin.poker.domain.card.PokerCardFactory

class PokerHandFactory(val pokerCardFactory: PokerCardFactory) {
    fun createFrom(stringCards: List<String>): PokerHand {
        val cards = stringCards.map { pokerCardFactory.createFrom(it) }
        return PokerHand(cards)
    }
}