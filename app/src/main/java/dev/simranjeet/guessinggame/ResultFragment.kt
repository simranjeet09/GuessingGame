package dev.simranjeet.guessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dev.simranjeet.guessinggame.databinding.FragmentResultBinding
import androidx.navigation.findNavController

class ResultFragment : Fragment() {

    private var _binding:FragmentResultBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: ResultViewModel
    lateinit var viewModelFactory: ResultViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        //USE Factory to get a reference to view model
        var result = ResultFragmentArgs.fromBundle(requireArguments()).result
        viewModelFactory = ResultViewModelFactory(result)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ResultViewModel::class.java)
        binding.wonLost.text = viewModel.result

        binding.newGameButton.setOnClickListener{
            view.findNavController().navigate(R.id.action_resultFragment_to_gameFragment)
        }
        return view;

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}