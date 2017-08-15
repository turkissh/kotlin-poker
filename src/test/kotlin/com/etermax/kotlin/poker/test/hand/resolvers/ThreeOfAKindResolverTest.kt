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

class ThreeOfAKindResolverTest : Spek({

    describe("a hand with three of a kind is resolved") {
        given("A hand with three of a kind") {
            val hand = createThreeOfAKindCardsHand()

            on("check if hand has three of a kind") {
                val handResolver = HandResolver()
                val highCardValue = handResolver.resolve(hand)

                it("finds three of a kind") {
                    highCardValue `should equal to` 300
                }
            }
        }
    }

})

private fun createThreeOfAKindCardsHand(): PokerHand {
    val pokerCardFactory = PokerCardFactory()
    val pokerHandFactory = PokerHandFactory(pokerCardFactory)

    return pokerHandFactory.createFrom(listOf("2H", "2C", "2D", "3S", "KC"))
}