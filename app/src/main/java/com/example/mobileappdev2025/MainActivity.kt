package com.example.mobileappdev2025

import android.nfc.Tag
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var leftNum: Int = 0;
    private var rightNum: Int = 0;
    private var submitOnClick: Boolean = false
    private var nextOnClick: Boolean = false
    private var topleftNum: Int = 0;
    private var toprightNum: Int = 0;


    private var score: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // above init layout ui

        pickName()
        setScore(0)
    }

    fun leftButtonOnClick(view: View) {
        if (leftNum > rightNum)
            setScore(score + 1)
        else
            setScore(score - 1)

    }

    fun rightButtonOnClick(view: View) {
        if (leftNum < rightNum)
            setScore(score + 1)
        else
            setScore(score - 1)


    }

    fun submitOnClick(view: View) {

        submitOnClick = true

        if (submitOnClick) {
            findViewById<ImageView>(R.id.spegitto).visibility = View.VISIBLE;
        } else {
            findViewById<ImageView>(R.id.spegitto).visibility = View.INVISIBLE;

            while (submitOnClick) {
                if (submitOnClick) {
                    submitOnClick = false
                    findViewById<ImageView>(R.id.gravehound).visibility = View.INVISIBLE;
                }
            }
        }
    }
        // fun nextOnClick(view: View){

        // nextOnClick = true

        //if (nextOnClick){
        //     findViewById<ImageView>(R.id.gravehound).visibility =  View.VISIBLE;
        // }
        // else{
        //   findViewById<ImageView>(R.id.gravehound).visibility = View.INVISIBLE;


        // }
        //  }

        // }

        fun pickName() {
            var name_one = findViewById<Button>(R.id.Name_one)
            var name_two = findViewById<Button>(R.id.name_two)
            var name_third = findViewById<Button>(R.id.name_3)
            var name_fourth = findViewById<Button>(R.id.name_4)


            name_one.text = "rydon"
            name_two.text = "pikachu"
            name_third.text = "spigitto"
            name_fourth.text = "swaddle"
        }

        fun setScore(_score: Int) {
            score = _score;


            //findViewById<ImageView>(R.id.you_win_image).visibility = if (score > 5) View.VISIBLE else View.INVISIBLE;

            findViewById<TextView>(R.id.score_text).text = "Score: $score"
        }

}