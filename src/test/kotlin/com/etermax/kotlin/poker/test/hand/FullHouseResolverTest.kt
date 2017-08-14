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


class FullHouseResolverTest: Spek({
    describe("a hand with full house is resolved") {
        given("A hand with full house") {
            val hand = createFullHouseCardsHand()

            on("check if hand has full house") {
                val handResolver = HandResolver()
                val highCardValue = handResolver.resolve(hand)

                it("finds the full house") {
                    highCardValue `should equal to` 600
                }
            }
        }
    }
})

private fun createFullHouseCardsHand(): PokerHand {
    val pokerCardFactory = PokerCardFactory()
    val pokerHandFactory = PokerHandFactory(pokerCardFactory)

    return pokerHandFactory.createFrom(listOf("3H", "3C", "3S", "5H", "5S"))
}
