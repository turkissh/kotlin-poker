package com.etermax.kotlin.poker.domain.hand

interface HandResolverUnit {
    fun resolve(hand: PokerHand): Int?
}

class RoyalFlushResolver : HandResolverUnit {
    override fun resolve(hand: PokerHand): Int? =
            if (StraightResolver().resolve(hand) != null && FlushResolver().resolve(hand) != null && isRoyalHand(hand)) 900 else null
}

class StraightFlushResolver : HandResolverUnit {
    override fun resolve(hand: PokerHand): Int? =
            if (StraightResolver().resolve(hand) != null && FlushResolver().resolve(hand) != null) 800 else null
}

class FourOfAKindResolver : HandResolverUnit {
    override fun resolve(hand: PokerHand): Int? =
            if (hand.cards.groupBy { it.number }.filter { it.value.size == 4 }.isNotEmpty()) 700 else null
}

class FullHouseResolver : HandResolverUnit {
    override fun resolve(hand: PokerHand): Int? =
            if (ThreeOfAKindResolver().resolve(hand) != null && PairResolver().resolve(hand) != null) 600 else null
}

class FlushResolver : HandResolverUnit {
    override fun resolve(hand: PokerHand): Int? =
            if (hand.cards.groupBy { it.suit }.mapValues { it.value.size }.filter { it.value == hand.cards.size }.isNotEmpty()) 500 else null
}

class StraightResolver : HandResolverUnit {
    override fun resolve(hand: PokerHand): Int? =
            if (handHasStraight(hand)) 400 else null
}

class ThreeOfAKindResolver : HandResolverUnit {
    override fun resolve(hand: PokerHand): Int? =
            if (hand.cards.groupBy { it.number }.filter { it.value.size == 3 }.isNotEmpty()) 300 else null
}

class TwoPairsResolver : HandResolverUnit {
    override fun resolve(hand: PokerHand): Int? =
            if (hand.cards.groupBy { it.number }.filter { it.value.size == 2 }.size == 2) 200 else null
}

class PairResolver : HandResolverUnit {
    override fun resolve(hand: PokerHand): Int? =
            if (hand.cards.groupBy { it.number }.filter { it.value.size == 2 }.isNotEmpty()) 100 else null
}

class HigherCardResolver : HandResolverUnit {
    override fun resolve(hand: PokerHand): Int? =
            hand.cards.sortedByDescending { pokerCard -> pokerCard.getCardValue() }.first().getCardValue()
}


private fun handHasStraight(hand: PokerHand): Boolean {
    val orderedValues = hand.cards.map { it.getCardValue() }.sorted()

    (0..orderedValues.size - 2).forEach({
        if (orderedValues[it] + 1 != orderedValues[it + 1]) {
            return false
        }
    })

    return true
}

private fun isRoyalHand(hand: PokerHand): Boolean {
    val startingFromTenValue = 10
    val orderedValues = hand.cards.map { it.getCardValue() }.sorted()

    (0..orderedValues.size - 2).forEach({
        if (orderedValues[it] + 1 != orderedValues[it + 1]) {
            return false
        }
    })

    return orderedValues[0] == startingFromTenValue
}