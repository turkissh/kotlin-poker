package com.etermax.kotlin.poker.domain.hand

class HandResolver {
    private val resolvers: List<HandResolverUnit> by lazy {
        listOf(RoyalFlushResolver(),
                StraightFlushResolver(),
                FourOfAKindResolver(),
                FullHouseResolver(),
                FlushResolver(),
                StraightResolver(),
                ThreeOfAKindResolver(),
                TwoPairsResolver(),
                PairResolver(),
                HigherCardResolver())
    }

    fun resolve(hand: PokerHand): Int {
        resolvers.forEach {
            val handValue = it.resolve(hand)
            if (handValue != null)
                return handValue
        }

        throw RuntimeException("No hand resolver can do it :(")
    }
}


