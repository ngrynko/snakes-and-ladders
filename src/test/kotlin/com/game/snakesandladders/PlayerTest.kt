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

    @Test
    fun `Given the player When move the token 3 spaces Then the current position should be eq to 4`(){
        testPlayer.moveToken(3)
        assertEquals(4, testPlayer.currentPosition)
    }

    @Test
    fun `Given the player When on 94 and die eq 6 Then the current position should be eq to 100`(){
        testPlayer.currentPosition = 94
        testPlayer.moveToken(6)
        assertEquals(100, testPlayer.currentPosition)
    }

    @Test
    fun `Given the player When on 95 and die eq 6 Then the current position should be eq to 95`(){
        testPlayer.currentPosition = 95
        testPlayer.moveToken(6)
        assertEquals(95, testPlayer.currentPosition)
    }

    @Test
    fun `Given the player When on 95 and die eq 1 Then the current position should be eq to 96`(){
        testPlayer.currentPosition = 95
        testPlayer.moveToken(1)
        assertEquals(96, testPlayer.currentPosition)
    }
}