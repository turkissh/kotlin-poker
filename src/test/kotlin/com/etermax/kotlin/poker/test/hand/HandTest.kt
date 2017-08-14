package com.etermax.kotlin.poker.test.hand

import com.etermax.kotlin.poker.domain.card.PokerCardFactory
import com.etermax.kotlin.poker.domain.hand.PokerHand
import com.etermax.kotlin.poker.domain.hand.PokerHandFactory
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class HandTest : Spek({

    describe("create hand") {

        given("five string cards") {
            val stringCards = listOf("5S", "JH", "7C", "3S", "5D")
            val pokerCardFactory = PokerCardFactory()
            val handFactory = PokerHandFactory(pokerCardFactory)

            on("create the hand") {
                val hand: PokerHand = handFactory.createFrom(stringCards)

                it("the hand is correct") {
                    hand.cards.size `should equal` 5
                }
            }
        }

    }

})

