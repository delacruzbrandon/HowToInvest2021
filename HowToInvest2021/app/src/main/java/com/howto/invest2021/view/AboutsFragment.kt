package com.howto.invest2021.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.howto.invest2021.R
import com.howto.invest2021.databinding.FragmentAboutsBinding

class AboutsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val aboutsBinding: FragmentAboutsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_abouts, container, false)
        aboutsBinding.clickHandler = this

        return aboutsBinding.root
    }

    fun onBack() {
        val action = AboutsFragmentDirections.actionAboutsFragmentToHomeFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}