package com.game.snakesandladders

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlayerTest {
    private val testPlayer = Player()

    @Test
    fun `Given teh player When didn't move the token Then the current position should be eq to 1`() {
        assertEquals(1, testPlayer.currentPosition)
    }

    @Test
    fun `Given the player When roll the die Then result should be number from 1 to 6`(){
        assertTrue(testPlayer.rollDie() in (1..6))
    }

    @Test
    fun `Given the player When current position is eq 100 Then the player has won the game`(){
        testPlayer.currentPosition = 100
        assertTrue(testPlayer.won())
    }

    @Test
    fun `Given the player When current position is eq 99 Then the player didn't win the game yet`(){
        testPlayer.currentPosition = 99
        assertFalse(testPlayer.won())
    }
}