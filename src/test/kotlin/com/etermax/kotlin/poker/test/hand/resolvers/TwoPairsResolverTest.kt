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


class TwoPairsResolverTest : Spek({

    describe("a hand with two pairs is resolved") {
        given("A hand with two pairs") {
            val hand = createTwoPairsCardsHand()

            on("check if hand has a pair") {
                val handResolver = HandResolver()
                val highCardValue = handResolver.resolve(hand)

                it("finds two pairs") {
                    highCardValue `should equal to` 200
                }
            }
        }
    }

})

private fun createTwoPairsCardsHand(): PokerHand {
    val pokerCardFactory = PokerCardFactory()
    val pokerHandFactory = PokerHandFactory(pokerCardFactory)

    return pokerHandFactory.createFrom(listOf("2H", "3C", "2D", "3S", "KC"))
}