package com.example.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {
    private var _binding: FragmentLetterListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        withViewModel()
    }

    private fun withViewModel() {
        binding.btnSubmit.setOnClickListener{
            viewModel.userInput(binding.etInputUser.text.toString())
            findNavController().navigate(R.id.action_letterListFragment_to_wordListFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
