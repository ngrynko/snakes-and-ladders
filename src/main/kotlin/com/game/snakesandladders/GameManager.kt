package com.game.snakesandladders

fun startGame(): GameWrapper {
    val game = Game()
    game.start()
    val player = Player()
    val initResult = listOf(GameResult(player.currentPosition, 0, player.currentPosition))
    return GameWrapper(game, player, initResult)
}

fun playRound(gameWrapper: GameWrapper ): GameWrapper {
    val dieScore = gameWrapper.player.rollDie()
    val initPosition  = gameWrapper.player.currentPosition
    gameWrapper.player.moveToken(dieScore)
    gameWrapper.gameResult = concat(gameWrapper.gameResult, GameResult(initPosition, dieScore, gameWrapper.player.currentPosition))
    if (gameWrapper.player.won()){
        gameWrapper.game.finish()
    }
    return gameWrapper
}

fun playGame(gameWrapper: GameWrapper): GameWrapper {
    var isFinished = gameWrapper.game.isFinished
    while(!isFinished){
        isFinished = playRound(gameWrapper).game.isFinished
    }
    return gameWrapper
}

private fun concat(origin: List<GameResult>, toAppend: GameResult) = listOf(origin, listOf(toAppend)).flatten()