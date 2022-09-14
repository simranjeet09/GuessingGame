package dev.simranjeet.guessinggame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class ResultViewModelFactory(private  val finalResult:String):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java))
            return  ResultViewModel(finalResult) as T

        throw IllegalArgumentException("Unknown ViewModel")

    }

}