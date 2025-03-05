package com.example.kabaddukounterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel

class KabaddiActivity : AppCompatActivity() {

//    var scoreA: Int = 0
//    var scoreB: Int = 0

    private lateinit var  tvScoreA: TextView
    private lateinit var  tvScoreB: TextView

    val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kabaddi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.kabaddi)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonPlusOneA = findViewById<Button>(R.id.button_team_a_plus1)
        val buttonPlusTwoA = findViewById<Button>(R.id.button_team_a_plus2)
        val buttonPlusOneB = findViewById<Button>(R.id.button_team_b_plus1)
        val buttonPlusTwoB = findViewById<Button>(R.id.button_team_b_plus2)
        val buttonReset =  findViewById<Button>(R.id.button_reset)

        tvScoreA = findViewById(R.id.team_a_score)
        tvScoreB = findViewById(R.id.team_b_score)

        tvScoreA.text = viewModel.scoreA.toString()
        tvScoreB.text = viewModel.scoreB.toString()


        buttonPlusOneA.setOnClickListener {
            incrementScoreA()
        }

        buttonPlusTwoA.setOnClickListener {
            incrementScoreA()
            incrementScoreA()
        }

        buttonPlusOneB.setOnClickListener {
            incrementScoreB()
        }

        buttonPlusTwoB.setOnClickListener {
            incrementScoreB()
            incrementScoreB()
        }

        buttonReset.setOnClickListener {
            resetScore()
        }
    }

    fun resetScore(){
        viewModel.resetScore()
        tvScoreA.text = viewModel.scoreA.toString()
        tvScoreB.text = viewModel.scoreB.toString()
    }

    fun incrementScoreA(){
        viewModel.incrementScoreA()
        tvScoreA.text = viewModel.scoreA.toString()
    }
    fun incrementScoreB(){
        viewModel.incrementScoreB()
        tvScoreB.text = viewModel.scoreB.toString()
    }
}