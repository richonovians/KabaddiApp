package com.example.kabaddukounterapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int>
        get() = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int>
        get() = _scoreB

    fun incrementScoreA() {
        _scoreA.value = _scoreA.value?.plus(1)
    }

    fun incrementScoreB() {
        _scoreB.value = _scoreB.value?.plus(1)
    }

    fun resetScore() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}
