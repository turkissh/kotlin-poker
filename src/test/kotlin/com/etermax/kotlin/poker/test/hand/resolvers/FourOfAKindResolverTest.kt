package com.etermax.kotlin.poker.test.hand.resolvers

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


class FourOfAKindResolverTest : Spek({
    describe("a hand with four of a kind is resolved") {
        given("A hand with four of a kind") {
            val hand = createFourOfAKindCardsHand()

            on("check if hand has four of a kind") {
                val handResolver = HandResolver()
                val highCardValue = handResolver.resolve(hand)

                it("finds the four of a kind") {
                    highCardValue `should equal to` 700
                }
            }
        }
    }
})

private fun createFourOfAKindCardsHand(): PokerHand {
    val pokerCardFactory = PokerCardFactory()
    val pokerHandFactory = PokerHandFactory(pokerCardFactory)

    return pokerHandFactory.createFrom(listOf("3H", "3C", "3S", "3D", "5S"))
}
