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


class PairResolverTest : Spek({

    describe("a hand with a pair is resolved") {
        given("A hand with a pair") {
            val hand = createPairCardHand()

            on("check if hand has a pair") {
                val handResolver = HandResolver()
                val highCardValue = handResolver.resolve(hand)

                it("finds a pair") {
                    highCardValue `should equal to` 100
                }
            }
        }
    }

})

private fun createPairCardHand(): PokerHand {
    val pokerCardFactory = PokerCardFactory()
    val pokerHandFactory = PokerHandFactory(pokerCardFactory)

    return pokerHandFactory.createFrom(listOf("2H", "3C", "2D", "JS", "KC"))
}