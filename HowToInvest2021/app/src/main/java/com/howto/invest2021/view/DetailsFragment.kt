package com.howto.invest2021.view

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.howto.invest2021.R
import com.howto.invest2021.database.DetailsDatabase
import com.howto.invest2021.databinding.FragmentDetailsBinding
import com.howto.invest2021.viewmodel.DetailsViewModel
import com.howto.invest2021.viewmodel.DetailsViewModelFactory

class DetailsFragment : Fragment() {

    private lateinit var detailsBinding: FragmentDetailsBinding

    private lateinit var detailsViewModelFactory: DetailsViewModelFactory
    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        val appContext: Application = requireNotNull(this.activity).application
        val daoContext = DetailsDatabase.getDatabaseInstance(appContext).detailsDao

        detailsViewModelFactory = DetailsViewModelFactory(daoContext, DetailsFragmentArgs.fromBundle(requireArguments()).details)
        detailsViewModel = ViewModelProvider(this, detailsViewModelFactory)[DetailsViewModel::class.java]

        detailsViewModel.ifSavedEvent.observe(viewLifecycleOwner, { detailsSaved ->
           onSave(detailsSaved)
        })

        detailsBinding.lifecycleOwner = viewLifecycleOwner
        detailsBinding.detailsViewModel =  detailsViewModel
        detailsBinding.clickHandler = this

        return detailsBinding.root
    }

    private fun onSave(detailsSaved: Boolean) {
        if (detailsSaved) {
            Toast.makeText(requireContext(), "Bookmarked", Toast.LENGTH_SHORT).show()
        }
    }

    fun onBack() {
        val action = DetailsFragmentDirections.actionDetailsFragmentToHomeFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}