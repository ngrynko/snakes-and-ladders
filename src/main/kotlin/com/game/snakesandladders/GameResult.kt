package com.game.snakesandladders

import com.google.gson.annotations.SerializedName

data class GameResult(@SerializedName("Initial position") val initPosition: Int,
                 @SerializedName("Die score") val dieScore: Int,
                 @SerializedName("Position after the move") val currentPosition: Int)