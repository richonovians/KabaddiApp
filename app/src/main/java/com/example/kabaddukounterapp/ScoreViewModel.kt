package com.example.kabaddukounterapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel:ViewModel() {
    private val _scoreA = MutableLiveData<Int>(0)
    val scoreA :LiveData<Int>
        get() = _scoreA
    var scoreB = MutableLiveData<Int>(0)

    fun incrementScoreA(){
        _scoreA.value = _scoreA.value?.plus(1)
    }

    fun incrementScoreB(){
        scoreB.value = scoreB.value?.plus(1)
    }

    fun resetScore(){
        _scoreA.value = 0
        scoreB.value = 0
    }
}