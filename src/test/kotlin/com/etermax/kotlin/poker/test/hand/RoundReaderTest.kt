package com.etermax.kotlin.poker.test.hand

import com.etermax.kotlin.poker.domain.card.PokerCard
import com.etermax.kotlin.poker.domain.card.PokerCardFactory
import com.etermax.kotlin.poker.domain.hand.PokerHandFactory
import com.etermax.kotlin.poker.domain.round.RoundReader
import org.amshove.kluent.`should contain`
import org.amshove.kluent.`should equal to`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


class RoundReaderTest : Spek({

    describe("read a hand of player one with first 5 cards") {
        given("a round with 10 cards") {
            val round = "5H 5C 6S 7S KD 2C 5C 7D 8S QH"
            val pokerHandFactory = createPokerHandFactory()
            val roundReader = RoundReader(pokerHandFactory)

            on("read hand of player 1") {
                val hand = roundReader.getHandOf(1, round)

                it("has five cards") {
                    hand.cards.size `should equal to` 5
                    hand.cards `should contain` PokerCard("5", PokerCard.Suit.HEART)
                    hand.cards `should contain` PokerCard("5", PokerCard.Suit.CLUB)
                    hand.cards `should contain` PokerCard("6", PokerCard.Suit.SPIKE)
                    hand.cards `should contain` PokerCard("7", PokerCard.Suit.SPIKE)
                    hand.cards `should contain` PokerCard("5", PokerCard.Suit.HEART)
                }
            }
        }
    }

    describe("read a hand of player two with last 5 cards") {
        given("a round with 10 cards") {
            val round = "5H 5C 6S 7S KD 2C 5C 7D 8S QH"
            val pokerHandFactory = createPokerHandFactory()
            val roundReader = RoundReader(pokerHandFactory)

            on("read hand of player 2") {
                val hand = roundReader.getHandOf(2, round)

                it("has five cards") {
                    hand.cards.size `should equal to` 5
                    hand.cards `should contain` PokerCard("2", PokerCard.Suit.CLUB)
                    hand.cards `should contain` PokerCard("5", PokerCard.Suit.CLUB)
                    hand.cards `should contain` PokerCard("7", PokerCard.Suit.DIAMOND)
                    hand.cards `should contain` PokerCard("8", PokerCard.Suit.SPIKE)
                    hand.cards `should contain` PokerCard("Q", PokerCard.Suit.HEART)
                }
            }
        }
    }

})

private fun createPokerHandFactory(): PokerHandFactory {
    val pokerCardFactory = PokerCardFactory()
    return PokerHandFactory(pokerCardFactory)
}

