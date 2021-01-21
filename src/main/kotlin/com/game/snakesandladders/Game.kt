package com.game.snakesandladders

data class Game(var isFinished: Boolean = true) {

    fun start(){
        isFinished = false
    }

    fun finish(){
        isFinished = true
    }
}