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


class StraightHandResolver: Spek({
    describe("a hand with straight is resolved") {
        given("A hand with straight") {
            val hand = createStraightCardsHand()

            on("check if hand has straight") {
                val handResolver = HandResolver()
                val highCardValue = handResolver.resolve(hand)

                it("finds the straight") {
                    highCardValue `should equal to` 400
                }
            }
        }
    }
})

private fun createStraightCardsHand(): PokerHand {
    val pokerCardFactory = PokerCardFactory()
    val pokerHandFactory = PokerHandFactory(pokerCardFactory)

    return pokerHandFactory.createFrom(listOf("2H", "3C", "4D", "5S", "6C"))
}