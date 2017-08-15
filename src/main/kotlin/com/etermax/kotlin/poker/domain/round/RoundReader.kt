package com.etermax.kotlin.poker.domain.round

import com.etermax.kotlin.poker.domain.hand.PokerHand
import com.etermax.kotlin.poker.domain.hand.PokerHandFactory

class RoundReader(val pokerHandFactory: PokerHandFactory) {
    fun getHandOf(player: Int, round: String): PokerHand {
        val startingCard = getStartingCardFromPlayer(player)
        val playerCards = round.split(" ").subList(startingCard, startingCard + 5)

        return pokerHandFactory.createFrom(playerCards)
    }

    private fun getStartingCardFromPlayer(player: Int): Int =
            when (player) {
                1 -> 0
                2 -> 5
                else -> throw RuntimeException("Invalid player")
            }
}