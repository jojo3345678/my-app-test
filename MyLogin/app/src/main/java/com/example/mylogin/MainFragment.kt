package com.example.mylogin

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mylogin.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        requireActivity().setTitle(R.string.txtpagemain)
        val viewModel: MainViewModel by viewModels()
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {


            btlogin.setOnClickListener {
                Navigation.findNavController(view)
                    .navigate(R.id.pageLogin1Fragment, arguments)
            }
            btregister.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }

}