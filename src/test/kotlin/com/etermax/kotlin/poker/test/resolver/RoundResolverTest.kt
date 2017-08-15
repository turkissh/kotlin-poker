package com.etermax.kotlin.poker.test.resolver

import com.etermax.kotlin.poker.domain.card.PokerCardFactory
import com.etermax.kotlin.poker.domain.hand.HandResolver
import com.etermax.kotlin.poker.domain.hand.PokerHand
import com.etermax.kotlin.poker.domain.round.RoundResolver
import org.amshove.kluent.`should equal to`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class RoundResolverTest : Spek({

    describe("player one has higher hand") {
        given("two players hands") {
            val playerOneHand = createHigherHand()
            val playerTwoHand = createLowerHand()

            on("check which player has higher hand") {
                val roundResolver = RoundResolver(HandResolver())
                val playerWinner = roundResolver.compareHands(playerOneHand, playerTwoHand)

                it("resolve player one has higher card") {
                    playerWinner `should equal to` 1
                }
            }
        }
    }

    describe("player two has higher hand") {
        given("two players hands") {
            val playerOneHand = createLowerHand()
            val playerTwoHand = createHigherHand()

            on("check which player has higher hand") {
                val roundResolver = RoundResolver(HandResolver())
                val playerWinner = roundResolver.compareHands(playerOneHand, playerTwoHand)

                it("resolve player two has higher card") {
                    playerWinner `should equal to` 2
                }
            }
        }

    }
})

private fun createLowerHand(): PokerHand {
    val cards = listOf("8C", "TS", "QC", "9H", "4S")
    val pokerCardFactory = PokerCardFactory()
    val pokerCards = cards.map { pokerCardFactory.createFrom(it) }
    return PokerHand(pokerCards)
}

private fun createHigherHand(): PokerHand {
    val cards = listOf("8C", "TS", "KC", "9H", "4S")
    val pokerCardFactory = PokerCardFactory()
    val pokerCards = cards.map { pokerCardFactory.createFrom(it) }
    return PokerHand(pokerCards)
}

