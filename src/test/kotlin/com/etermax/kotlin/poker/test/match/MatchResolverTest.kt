package com.etermax.kotlin.poker.test.match

import com.etermax.kotlin.poker.domain.card.PokerCardFactory
import com.etermax.kotlin.poker.domain.hand.HandResolver
import com.etermax.kotlin.poker.domain.hand.PokerHandFactory
import com.etermax.kotlin.poker.domain.match.MatchResolver
import com.etermax.kotlin.poker.domain.round.RoundReader
import com.etermax.kotlin.poker.domain.round.RoundResolver
import org.amshove.kluent.`should equal to`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


class MatchResolverTest : Spek({

    describe("given many rounds resolve which player wins") {
        given("many rounds of a match") {
            val match = getDummyMatch()
            val roundReader = createRoundReader()
            val roundResolver = createRoundResolver()
            val matchResolver = MatchResolver(roundReader, roundResolver)

            on("resolve match") {
                val playerWinner: Int = matchResolver.getPlayerWinner(match)

                it("player 2 is the winner") {
                    playerWinner `should equal to` 2
                }
            }
        }
    }

})

fun createRoundResolver(): RoundResolver = RoundResolver(HandResolver())

fun createRoundReader(): RoundReader {
    val pokerHandFactory = PokerHandFactory(PokerCardFactory())
    return RoundReader(pokerHandFactory)
}

fun getDummyMatch(): List<String> =
        listOf("5H 5C 6S 7S KD 2C 5C 7D 8S QH", //wins p1
                "2D 9C AS AH AC 3D 6D 7D TD QD", //wins p2
                "5D 8C 9S JS AC 4D 6S 9H QH QC", //wins p2
                "2D 9C AS AH AC 3C 3D 3S 9S 9D") //wins p2

