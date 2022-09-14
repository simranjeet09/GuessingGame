package dev.simranjeet.guessinggame

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    //Game variables
    val words = listOf("Android", "Barrie", "Georgian")   //list of available words
    val secretWord = words.random().uppercase()  //Randomly picked word the user has to display
    var secretWordDisplay = ""
    var correctGuesses = ""
    var incorrectGuesses = ""
    var livesLeft = 8
    // Derive Secrete Word Display

    init {
        secretWordDisplay = deriveSecretWordDisplay()
    }

    fun deriveSecretWordDisplay(): String {

        var display = ""
        secretWord.forEach {
            display += checkLetter(it.toString())
        }

        return display
    }
    //check letter
    fun checkLetter(str: String) = when (correctGuesses.contains(str)) {
        true -> str
        false -> "_"
    }

    //Make Guess
    fun makeGuess(guess: String) {
        if (guess.length == 1) {
            if (secretWord.contains(guess)) {
                correctGuesses += guess
                secretWordDisplay = deriveSecretWordDisplay()
            } else {
                incorrectGuesses += " $guess"
                livesLeft--
            }
        }
    }

    //Check win
    fun isWon() = secretWord.equals(secretWordDisplay, true)

    //Check lost
    fun isLost() = livesLeft <= 0

    //Display Win/Lose message
    fun wonLostMessage(): String {
        var message = ""
        if (isWon()) {
            message = "You Won"
        } else if (isLost()) {
            message = "You Lost!"
        }
        message += " The word was $secretWord."
        return message
    }



}