package com.baxramov.atomichabits.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.baxramov.atomichabits.R
import com.baxramov.atomichabits.databinding.FragmentHabitsListBinding

class HabitsListFragment : Fragment() {

    private var _binding: FragmentHabitsListBinding? = null
    private val binding: FragmentHabitsListBinding
        get() = _binding ?: throw NullPointerException("FragmentHabitsListBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHabitsListBinding.inflate(this.layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createNewHabitFloatingActionBtn.setOnClickListener {
            findNavController().navigate(R.id.action_habitsListFragment_to_createNewHabitFragment)
        }
    }

    override fun onDestroy() {
        if (_binding != null) {
            _binding = null
        }
        super.onDestroy()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HabitsListFragment()
    }
}