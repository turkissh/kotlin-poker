package com.etermax.kotlin.poker.domain.round

import com.etermax.kotlin.poker.domain.hand.HandResolver
import com.etermax.kotlin.poker.domain.hand.PokerHand

class RoundResolver(val handResolver: HandResolver) {
    fun compareHands(playerOneHand: PokerHand, playerTwoHand: PokerHand): Int {
        val playerOneHandPoints = handResolver.resolve(playerOneHand)
        val playerTwoHandPoints = handResolver.resolve(playerTwoHand)
        return if (playerOneHandPoints > playerTwoHandPoints) 1 else 2
    }
}