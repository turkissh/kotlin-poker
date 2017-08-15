package com.etermax.kotlin.poker.test.hand.resolvers

import com.etermax.kotlin.poker.domain.card.PokerCardFactory
import com.etermax.kotlin.poker.domain.hand.HandResolver
import com.etermax.kotlin.poker.domain.hand.PokerHand
import com.etermax.kotlin.poker.domain.hand.PokerHandFactory
import org.amshove.kluent.`should be`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


class HigherCardResolverTest : Spek({

    describe("find higher card in hand") {

        given("A hand with higher card") {
            val hand = createHigherCardHand()

            on("check hand only has high card") {
                val handResolver = HandResolver()
                val highCardValue = handResolver.resolve(hand)

                it("finds the higher card") {
                    highCardValue `should be` 13
                }
            }
        }
    }

})

private fun createHigherCardHand(): PokerHand {
    val pokerCardFactory = PokerCardFactory()
    val pokerHandFactory = PokerHandFactory(pokerCardFactory)

    return pokerHandFactory.createFrom(listOf("2H", "3C", "TD", "JS", "KC"))
}
