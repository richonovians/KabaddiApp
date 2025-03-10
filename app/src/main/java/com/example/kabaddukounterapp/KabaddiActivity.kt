package com.example.kabaddukounterapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.kabaddukounterapp.databinding.ActivityKabaddiBinding

class KabaddiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKabaddiBinding
    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_kabaddi)
        binding.lifecycleOwner = this
        binding.scoreViewModel = viewModel

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.kabaddi)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Mengamati Perubahan Skor
        viewModel.scoreA.observe(this, Observer { score ->
            binding.teamAScore.text = score.toString()
        })

        viewModel.scoreB.observe(this, Observer { score ->
            binding.teamBScore.text = score.toString()
        })

        // Mengatur tombol dengan listener yang memanggil fungsi ViewModel
        binding.buttonTeamAPlus1.setOnClickListener { viewModel.incrementScoreA() }
        binding.buttonTeamAPlus2.setOnClickListener {
            viewModel.incrementScoreA()
            viewModel.incrementScoreA()
        }
        binding.buttonTeamBPlus1.setOnClickListener { viewModel.incrementScoreB() }
        binding.buttonTeamBPlus2.setOnClickListener {
            viewModel.incrementScoreB()
            viewModel.incrementScoreB()
        }
        binding.buttonReset.setOnClickListener { viewModel.resetScore() }
    }
}
