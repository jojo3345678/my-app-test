package com.example.mylogin

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mylogin.databinding.FragmentPageLogin2Binding

class PageLogin2Fragment : Fragment() {

    private lateinit var binding: FragmentPageLogin2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        requireActivity().setTitle(R.string.txtloginpage2)
        val viewModel: PageLogin2ViewModel by viewModels()
        binding = FragmentPageLogin2Binding.inflate(inflater, container, false)
        binding.viewModel= viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            // arguments即為前頁傳來的bundle，如果不為null即可取值
            arguments?.let {
                viewModel?.user?.value = it.getSerializable("user") as User?
            }


        }
    }
}