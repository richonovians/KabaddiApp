package com.example.kabaddukounterapp

import androidx.lifecycle.ViewModel

class ScoreViewModel:ViewModel() {
    var scoreA: Int = 0
    var scoreB: Int = 0

    fun incrementScoreA(){
        scoreA++
    }

    fun incrementScoreB(){
        scoreB++
    }

    fun resetScore(){
        scoreA = 0
        scoreB = 0
    }
}