package com.howto.invest2021.view

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
import com.howto.invest2021.databinding.FragmentHomeBinding
import com.howto.invest2021.model.DetailsModel
import com.howto.invest2021.viewmodel.HomeViewModel
import org.imaginativeworld.whynotimagecarousel.CarouselItem

class HomeFragment : Fragment(), OnAdapterClickListener {

    private lateinit var navController: NavController
    private lateinit var detailsList: List<DetailsModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val homeBinding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val homeViewModel: HomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val carouselList: List<CarouselItem> = listOf(
            CarouselItem(R.drawable.stock_photo),
            CarouselItem(R.drawable.stock_photo),
            CarouselItem(R.drawable.stock_photo),
            CarouselItem(R.drawable.stock_photo),
            CarouselItem(R.drawable.stock_photo)
        )

        navController = NavHostFragment.findNavController(this@HomeFragment)

        homeBinding.imageViewCarouselHomeFragmentFeatured.addData(carouselList)
        homeBinding.clickHandler = this

        homeViewModel.detailList.observe(viewLifecycleOwner, {
            detailsList = it
            homeBinding.recyclerViewHomeFragmentContent.adapter = RecyclerAdapter(this, requireContext(), it)
        })

        return homeBinding.root
    }

    override fun onClick(position: Int) {
        onDetails(position)
    }

    private fun getDetails(position: Int): DetailsModel {
        return detailsList[position]
    }

    private fun onDetails(position: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(getDetails(position))
        navController.navigate(action)
    }

    fun onAbouts() {
        val action = HomeFragmentDirections.actionHomeFragmentToAboutsFragment()
        navController.navigate(action)
    }

    fun onBookmark() {
        val action = HomeFragmentDirections.actionHomeFragmentToBookmarkFragment()
        navController.navigate(action)
    }

}