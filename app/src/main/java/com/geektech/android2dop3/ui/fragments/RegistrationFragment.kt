package com.geektech.android2dop3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.android2dop3.R
import com.geektech.android2dop3.databinding.FragmentRegistrationBinding
import com.geektech.android2dop3.utils.PreferenceHelper

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding
    private val preferenceHelper = PreferenceHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() {
        preferenceHelper.unit(requireContext())
    }
    private fun setupListeners() = with(binding){
        btnPassword.setOnClickListener{
            preferenceHelper.safeText = etEmail.text.toString().trim()
            preferenceHelper.safePass = etPassword.text.toString().trim()

            if (etEmail.length() == 0 || etPassword.length() == 0) {
                if (etEmail.length() == 0) {
                    etEmail.error = "заполните поле"
                }
                if (etPassword.length() == 0) {
                    etPassword.error = "заполните поле"
                }
            }else if (etEmail.length() < 5 || etPassword.length() < 8){
                if (etEmail.length() < 5){
                    etEmail.error = "логин не можут быть меньше 5 символов"
                }
                if (etPassword.length() < 8){
                    etPassword.error = "пароль не можут быть меньше 8 символов"
                }
            }
            else{
                findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
            }
        }
    }
}