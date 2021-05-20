package com.howto.invest2021.view

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.howto.invest2021.R
import com.howto.invest2021.adapter.RecyclerAdapter
import com.howto.invest2021.callback.OnAdapterClickListener
import com.howto.invest2021.database.DetailsDatabase
import com.howto.invest2021.database.DetailsDatabaseDao
import com.howto.invest2021.databinding.FragmentBookmarkBinding
import com.howto.invest2021.model.DetailsModel
import com.howto.invest2021.viewmodel.BookmarkViewModel
import com.howto.invest2021.viewmodel.BookmarkViewModelFactory

class BookmarkFragment : Fragment(), OnAdapterClickListener {

    private lateinit var navController: NavController
    private lateinit var detailsList: List<DetailsModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bookmarkBinding: FragmentBookmarkBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)

        val appContext: Application = requireNotNull(this.activity).application
        val daoContext: DetailsDatabaseDao = DetailsDatabase.getDatabaseInstance(appContext).detailsDao

        navController = NavHostFragment.findNavController(this@BookmarkFragment)

        val bookmarkViewModelFactory = BookmarkViewModelFactory(daoContext)
        val bookmarkViewModel = ViewModelProvider(this, bookmarkViewModelFactory)[BookmarkViewModel::class.java]

        bookmarkBinding.lifecycleOwner = viewLifecycleOwner
        bookmarkBinding.bookmarkViewModel = bookmarkViewModel
        bookmarkBinding.clickHandler = this@BookmarkFragment

        // TODO FIX IT: this is null
        bookmarkViewModel.allDetails.observe(viewLifecycleOwner, {
            detailsList = it
            bookmarkBinding.recyclerViewBookmarkFragmentStorage.adapter = RecyclerAdapter(this, requireContext(), it)
        })

        return bookmarkBinding.root
    }

    override fun onClick(position: Int) {
        onDetails(position)
    }

    fun onBack() {
        val action = BookmarkFragmentDirections.actionBookmarkFragmentToHomeFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun getDetails(position: Int): DetailsModel {
        return detailsList[position]
    }

    private fun onDetails(position: Int) {
        val action = BookmarkFragmentDirections.actionBookmarkFragmentToDetailsFragment(getDetails(position))
        navController.navigate(action)
    }

}