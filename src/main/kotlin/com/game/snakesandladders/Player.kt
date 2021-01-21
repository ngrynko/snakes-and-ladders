package com.game.snakesandladders

data class Player(var currentPosition: Int = 1) {

    fun rollDie(): Int{
        return (1..6).random()
    }

    fun won(): Boolean{
        return currentPosition == 100
    }

    fun moveToken(times: Int){
        if(currentPosition + times <= 100){
            currentPosition += times
        }
    }
}