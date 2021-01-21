package com.game.snakesandladders

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GameTest {
    private val testGame = Game()

    @Test
    fun `Given the game When is not started Then the isFinished eq true`(){
        assertTrue(testGame.isFinished)
    }

    @Test
    fun `Given the game When is started Then the isFinished eq false`(){
        testGame.start()
        assertFalse(testGame.isFinished)
    }

    @Test
    fun `Given the game When is finished Then the isFinished eq true`(){
        testGame.finish()
        assertTrue(testGame.isFinished)
    }
}