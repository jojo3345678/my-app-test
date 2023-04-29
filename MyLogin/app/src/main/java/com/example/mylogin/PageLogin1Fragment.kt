package com.example.mylogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mylogin.databinding.FragmentPageLogin1Binding


class PageLogin1Fragment : Fragment() {

    private lateinit var binding: FragmentPageLogin1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        requireActivity().setTitle(R.string.txtlogin)
        val viewModel: PageLogin1ViewModel by viewModels()
        binding = FragmentPageLogin1Binding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel?.uid?.observe(viewLifecycleOwner) {
                inputValid()
            }
            viewModel?.password?.observe(viewLifecycleOwner) {
                inputValid()
            }

            btlogin2.setOnClickListener {
                if (!inputValid()) {
                    return@setOnClickListener
                }
                val bundle = Bundle()
                val uid = viewModel!!.uid.value
                val password = viewModel!!.password.value
                val user = User(uid, password)
                // 可將基本類型或字串放進Bundle
                bundle.putString("uid", uid)
                bundle.putString("password", password)
                // 可將Serializable物件放進Bundle
                bundle.putSerializable("user", user)
                // 將Bundle帶至下一頁
                Navigation.findNavController(it).navigate(
                    R.id.action_pageLogin1Fragment_to_pageLogin2Fragment,
                    bundle
                )
            }
        }
    }

    private fun inputValid(): Boolean {
        var valid = true
        with(binding) {
            val uid = viewModel?.uid?.value?.trim()
            val password = viewModel?.password?.value?.trim()
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            if (uid == null || uid.isEmpty()) {
                etloginmail.error = getString(R.string.errmail)
                valid = false
            }else if (!uid.matches(emailPattern.toRegex())) {
                etloginmail.error = getString(R.string.errmailformat)
                valid = false
            }
            if (password == null || password.isEmpty()) {
                etloginpassword.error = getString(R.string.errpassword)
                valid = false
            }
        }
        return valid
    }
}