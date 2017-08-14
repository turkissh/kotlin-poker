package com.etermax.kotlin.poker.domain.round

import com.etermax.kotlin.poker.domain.hand.HandResolver
import com.etermax.kotlin.poker.domain.hand.PokerHand

class RoundResolver(val handResolver: HandResolver) {
    fun compareHands(playerOneHand: PokerHand, playerTwoHand: PokerHand): Int {
        val playerOneHigherCard = handResolver.resolve(playerOneHand)
        val playerTwoHigherCard = handResolver.resolve(playerTwoHand)
        return playerOneHigherCard.compareTo(playerTwoHigherCard)
    }
}