package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
//import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    // Функция которая задает число граней игральной кости, получает рандомное значение. Присваевает его переменной которую преобразуется в строку и подставляется в textView

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val diceL = Dice(6)
        val diceR = Dice(6)
        val diceRollL = diceL.roll()
        val diceRollR = diceR.roll()
        // Find the ImageView in the layout
        // Найти изображение в макете
        val diceImageL: ImageView = findViewById(R.id.imageViewL)
        val diceImageR: ImageView = findViewById(R.id.imageViewR)
        // Determine which drawable resource ID to use based on the dice roll
        val drawableResourceL = when (diceRollL) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResourceR = when (diceRollR) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //diceImage.setImageResource(drawableResource) запись присвоения числа картинки с числом
        // Update the ImageView with the correct drawable resource ID
        diceImageL.setImageResource(drawableResourceL)
        // Update the content description
        diceImageL.contentDescription = diceRollL.toString()

        diceImageR.setImageResource(drawableResourceR)
        // Update the content description
        diceImageR.contentDescription = diceRollR.toString()
    }


    //Класс который возвращает рандомное число от 1 до numSides(задается в тругой функции)
    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }

    }
}


/*
вывод тоста четез переменную toast
//__________
 val toast = Toast.makeText(this,"Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
//__________
 */