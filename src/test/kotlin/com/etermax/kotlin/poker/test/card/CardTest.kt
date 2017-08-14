package com.etermax.kotlin.poker.test.card

import com.etermax.kotlin.poker.domain.card.PokerCard
import com.etermax.kotlin.poker.domain.card.PokerCardFactory
import org.amshove.kluent.`should equal to`
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class CardTest : Spek({

    describe("create card from string") {

        given("A string representing a card") {
            val cardString = "5S"
            val pokerCardFactory = PokerCardFactory()

            on("create card") {
                val card = pokerCardFactory.createFrom(cardString)

                it("create a card 5 of spikes") {
                    card.number `should equal to` "5"
                    card.getCardValue() `should equal to` 5
                    card.suit `should equal` PokerCard.Suit.SPIKE
                }
            }
        }

    }

})

