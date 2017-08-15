package com.etermax.kotlin.poker.domain.match

import com.etermax.kotlin.poker.domain.round.RoundReader
import com.etermax.kotlin.poker.domain.round.RoundResolver

class MatchResolver(private val roundReader: RoundReader, private val roundResolver: RoundResolver) {
    fun getPlayerWinner(match: List<String>): Int {
        val roundsWon = HashMap<Int, Int>()
        match.forEach({
            val handP1 = roundReader.getHandOf(1, it)
            val handP2 = roundReader.getHandOf(2, it)
            val playerWinner = roundResolver.compareHands(handP1, handP2)
            roundsWon.compute(playerWinner, { _, roundWon -> roundWon?.let { it + 1 } ?: 1 })
        })

        return roundsWon.maxBy { entry -> entry.value }!!.key
    }

}