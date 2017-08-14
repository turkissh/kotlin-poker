package com.etermax.kotlin.poker.test.hand

import com.etermax.kotlin.poker.domain.card.PokerCardFactory
import com.etermax.kotlin.poker.domain.hand.HandResolver
import com.etermax.kotlin.poker.domain.hand.PokerHand
import com.etermax.kotlin.poker.domain.hand.PokerHandFactory
import org.amshove.kluent.`should equal to`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


class StraightFlushTest: Spek({
    describe("a hand with straight flush is resolved") {
        given("A hand with straight flush") {
            val hand = createStraightFlushCardsHand()

            on("check if hand has straight flush") {
                val handResolver = HandResolver()
                val highCardValue = handResolver.resolve(hand)

                it("finds the straight flush") {
                    highCardValue `should equal to` 800
                }
            }
        }
    }
})

private fun createStraightFlushCardsHand(): PokerHand {
    val pokerCardFactory = PokerCardFactory()
    val pokerHandFactory = PokerHandFactory(pokerCardFactory)

    return pokerHandFactory.createFrom(listOf("5H", "6H", "7H", "8H", "9H"))
}
