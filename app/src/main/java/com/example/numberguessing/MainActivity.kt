package com.example.numberguessing

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random as KotlinRandomRandom


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersToButton()
        btnLeft.setOnClickListener{
            //code here will run everytime button
            //compare the numbers in the boxes
            checkAnswer(true)
            //2. random new number
            assignNumbersToButton()

        }
        btnRight.setOnClickListener{
            //1.compare the numbers in the boxes
            checkAnswer(false)
            //2. Pick new Random numbers
            assignNumbersToButton()
        }
    }
    private fun checkAnswer(isLeftButtonSelected:Boolean){
        val leftNum = btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()
        val isAnswerCorrect = if(isLeftButtonSelected) leftNum > rightNum else rightNum>leftNum
        if(isAnswerCorrect){
            //correct ans
            //change background color
            backgroundView.setBackgroundColor(Color.GREEN)
            //show a toast(notification)
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show()
        }else{
            //wrong answer
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButton() {
        val r = Random()
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while(rightNum == leftNum){
            rightNum = r.nextInt(10)
        }
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()
    }
}