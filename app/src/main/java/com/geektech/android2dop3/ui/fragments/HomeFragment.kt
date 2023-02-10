package com.geektech.android2dop3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.android2dop3.R
import com.geektech.android2dop3.databinding.FragmentHomeBinding
import com.geektech.android2dop3.utils.PreferenceHelper

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val  preferenceHelper = PreferenceHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() = with(binding){
        preferenceHelper.unit(requireContext())
        etEmail2.text = preferenceHelper.safeText
        etPassword2.text = preferenceHelper.safePass
    }
}