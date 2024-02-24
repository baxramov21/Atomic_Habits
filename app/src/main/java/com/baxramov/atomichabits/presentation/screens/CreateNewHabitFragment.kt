package com.baxramov.atomichabits.presentation.screens

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.baxramov.atomichabits.databinding.FragmentCreateNewHabitBinding
import com.baxramov.atomichabits.presentation.view_model.HabitTrackerViewModel
import com.baxramov.atomichabits.presentation.view_model.HabitTrackerViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


class CreateNewHabitFragment : Fragment() {

    private var _binding: FragmentCreateNewHabitBinding? = null
    private val binding: FragmentCreateNewHabitBinding
        get() = _binding ?: throw NullPointerException("FragmentCreateNewHabitBinding is null")

    private val viewModelFactory by lazy {
        HabitTrackerViewModelFactory(requireActivity().application)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HabitTrackerViewModel::class.java]
    }

    private val backgroundCoroutineScope = CoroutineScope(Dispatchers.IO)
    private val mainCoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateNewHabitBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun checkIfEverythingFilled(): Boolean {
        var isFilled = false
        with(binding) {
            if (checkIfEditTextIsEmpty(etInputHabitName) &&
                checkIfEditTextIsEmpty(etInputHabitRepetitionGoal)
            ) isFilled = true
        }
        return isFilled
    }

    private fun checkIfEditTextIsEmpty(editText: EditText): Boolean {
        return editText.text.isNullOrEmpty()
    }

    private fun navigateToDestination(@IdRes actionId: Int) {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(actionId)
    }

    override fun onDestroy() {
        if (_binding != null) {
            _binding = null
        }
        super.onDestroy()
    }

    companion object {
        fun newInstance() = CreateNewHabitFragment()
    }
}