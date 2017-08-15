package com.etermax.kotlin.poker.rest.resources

import com.etermax.kotlin.poker.domain.card.PokerCardFactory
import com.etermax.kotlin.poker.domain.hand.HandResolver
import com.etermax.kotlin.poker.domain.hand.PokerHandFactory
import com.etermax.kotlin.poker.domain.match.MatchResolver
import com.etermax.kotlin.poker.domain.round.RoundReader
import com.etermax.kotlin.poker.domain.round.RoundResolver
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
class PokerResource {

    private val matchResolver by lazy {
        val pokerHandFactory = PokerHandFactory(PokerCardFactory())
        val roundReader = RoundReader(pokerHandFactory)
        val roundResolver = RoundResolver(HandResolver())
        MatchResolver(roundReader, roundResolver)
    }

    @GET
    @Path("/show/winner")
    fun showHand(): WinnerResponse {
        val matchRoundList = getMatch() ?: throw RuntimeException("unable to load match")
        val playerWinner = matchResolver.getPlayerWinner(matchRoundList)
        return WinnerResponse(playerWinner)
    }

    private fun getMatch(): MutableList<String>? {
        return Files.readAllLines(File("poker.txt").toPath(), Charset.defaultCharset())
    }

}

data class WinnerResponse(@JsonProperty("player_winner") val winner: Int)