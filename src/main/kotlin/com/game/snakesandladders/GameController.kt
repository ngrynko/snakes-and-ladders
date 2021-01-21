package com.game.snakesandladders

import com.google.gson.Gson
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/snakes-and-ladders")
class GameController {
    @GetMapping
    private fun playGame(): String {
        val gameWrapper = startGame()
        playGame(gameWrapper)
        return Gson().toJson(gameWrapper.gameResult)
    }

}