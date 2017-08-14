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


class RoyalFlushResolverTest: Spek({
    describe("a hand with royal flush is resolved") {
        given("A hand with royal flush") {
            val hand = createStraightFlushCardsHand()

            on("check if hand has royal flush") {
                val handResolver = HandResolver()
                val highCardValue = handResolver.resolve(hand)

                it("finds the royal flush") {
                    highCardValue `should equal to` 900
                }
            }
        }
    }
})

private fun createStraightFlushCardsHand(): PokerHand {
    val pokerCardFactory = PokerCardFactory()
    val pokerHandFactory = PokerHandFactory(pokerCardFactory)

    return pokerHandFactory.createFrom(listOf("TH", "JH", "QH", "KH", "AH"))
}
