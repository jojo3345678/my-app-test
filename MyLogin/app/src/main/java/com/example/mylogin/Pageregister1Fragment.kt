package com.example.mylogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mylogin.databinding.FragmentPageregister1Binding


class Pageregister1Fragment : Fragment() {

    private lateinit var binding: FragmentPageregister1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        requireActivity().setTitle(R.string.txttregister)
        val viewModel: Pageregister1ViewModel by viewModels()
        binding = FragmentPageregister1Binding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel?.name?.observe(viewLifecycleOwner) {
                inputValid()
            }
            viewModel?.uid?.observe(viewLifecycleOwner) {
                inputValid()
            }
            viewModel?.password?.observe(viewLifecycleOwner) {
                inputValid()
            }

            btregister2.setOnClickListener {
                if (!inputValid()) {
                    return@setOnClickListener
                }
                val bundle = Bundle()
                val name = viewModel!!.name.value
                val uid = viewModel!!.uid.value
                val password = viewModel!!.password.value
                val user = User(uid, password)
                // 可將基本類型或字串放進Bundle
                bundle.putString("name", name)
                bundle.putString("uid", uid)
                bundle.putString("password", password)
                // 可將Serializable物件放進Bundle
                bundle.putSerializable("user", user)
                // 將Bundle帶至下一頁
                Navigation.findNavController(it).navigate(
                    R.id.action_pageregister1Fragment_to_pageregister2Fragment,
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
            val passwordAgain = etregisterpassword2.text.toString()
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            if (uid == null || uid.isEmpty()) {
                etregistermail.error = getString(R.string.errmail)
                valid = false
            }else if (!uid.matches(emailPattern.toRegex())) {
                etregistermail.error = getString(R.string.errmailformat)
                valid = false
            }
            if (password == null || password.isEmpty()) {
                etregisterpassword.error = getString(R.string.errpassword)
                valid = false
            }else if (password != passwordAgain) {
                etregisterpassword2.error = getString(R.string.errpasswordnomatch)
                valid = false
            }
        }
        return valid
    }
}