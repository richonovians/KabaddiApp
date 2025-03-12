package com.example.kabaddukounterapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> get() = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> get() = _scoreB

    // LiveData untuk Winner
    private val _winnerText = MediatorLiveData<String>().apply { value = "" }
    val winnerText: LiveData<String> get() = _winnerText

    init {
        // Observe perubahan scoreA dan scoreB
        _winnerText.addSource(_scoreA) { checkWinner() }
        _winnerText.addSource(_scoreB) { checkWinner() }
    }

    private fun checkWinner() {
        _winnerText.value = when {
            _scoreA.value ?: 0 >= 25 -> "Team A Wins!"
            _scoreB.value ?: 0 >= 25 -> "Team B Wins!"
            else -> ""
        }
    }

    fun incrementScoreA() {
        _scoreA.value = (_scoreA.value ?: 0) + 1
    }

    fun incrementScoreB() {
        _scoreB.value = (_scoreB.value ?: 0) + 1
    }

    fun resetScore() {
        _scoreA.value = 0
        _scoreB.value = 0
        _winnerText.value = "" // Reset teks winner juga
    }
}

