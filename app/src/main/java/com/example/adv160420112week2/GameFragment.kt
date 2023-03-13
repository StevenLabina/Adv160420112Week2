package com.example.adv160420112week2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_game.view.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_result.*
import java.util.*
import kotlin.random.Random

import kotlin.random.Random.Default.nextInt

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val number1 = Random.nextInt(1,100)
        val number2 = Random.nextInt(1,100)
        txtNumber1.setText(number1.toString())
        txtNumber2.setText(number2.toString())
        var finalScore = 0
        val result = (number1 + number2).toString()
        btnSubmit.setOnClickListener {
            var userAnswer = txtAnswer.text.toString()
            if (result == userAnswer){
                finalScore++
                val action = GameFragmentDirections.actionResultFragment(finalScore)
                Navigation.findNavController(it).navigate(action)

            }
            if (result != userAnswer){
                val action = GameFragmentDirections.actionResultFragment(finalScore)
                Navigation.findNavController(it).navigate(action)
            }
        }
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
    }
}





