package com.game.snakesandladders

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class GameManagerTest {

    @Test
    fun `Given game manager When requested to play the game Then player and game result should be created and game started`(){
        val gameWrapper = startGame()
        assertFalse(gameWrapper.game.isFinished)
        assertEquals(1, gameWrapper.player.currentPosition)
        assertEquals(1, gameWrapper.gameResult.first().initPosition)
    }

    @Test
    fun `Given game manager When requested to play a round Then player roll the die and move number of times`(){
        val gameWrapper =  playRound(startGame())
        assertFalse(gameWrapper.game.isFinished)
        assertTrue(gameWrapper.player.currentPosition > 1)
        assertTrue(gameWrapper.gameResult.last().currentPosition > 1)
    }

    @Test
    fun `Given game manager When player has won Then the game should be finished`(){
        val mockPlayer = mock(Player::class.java)
        given(mockPlayer.won()).willReturn(true)
        val game = Game()
        game.start()
        val gameWrapper = playRound(GameWrapper(game, mockPlayer, emptyList()))
        assertTrue(gameWrapper.game.isFinished)
    }

    @Test
    fun `Given game manager When game is played Then the game should be finished and player should win`() {
        val gameWrapper = playGame(startGame())
        assertTrue(gameWrapper.game.isFinished)
        assertTrue(gameWrapper.player.won())
        assertTrue(gameWrapper.gameResult.last().currentPosition == 100)
    }
}