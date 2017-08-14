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

class FlushResolverTest : Spek({
    describe("a hand with flush is resolved") {
        given("A hand with flush") {
            val hand = createFlushCardsHand()

            on("check if hand has flush") {
                val handResolver = HandResolver()
                val highCardValue = handResolver.resolve(hand)

                it("finds the flush") {
                    highCardValue `should equal to` 500
                }
            }
        }
    }
})

private fun createFlushCardsHand(): PokerHand {
    val pokerCardFactory = PokerCardFactory()
    val pokerHandFactory = PokerHandFactory(pokerCardFactory)

    return pokerHandFactory.createFrom(listOf("2H", "3H", "4H", "5H", "QH"))
}

