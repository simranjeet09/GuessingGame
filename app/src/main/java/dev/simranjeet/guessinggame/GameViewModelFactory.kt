package dev.simranjeet.guessinggame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class GameViewModelFactory( ):ViewModelProvider.Factory {
    //We can add parameter if required
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java))
            return  GameViewModel() as T

        throw IllegalArgumentException("Unknown ViewModel")

    }

}