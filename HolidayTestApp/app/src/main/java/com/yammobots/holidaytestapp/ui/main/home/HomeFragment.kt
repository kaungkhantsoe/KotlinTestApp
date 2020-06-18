package com.yammobots.holidaytestapp.ui.main.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.yammobots.holidaytestapp.R
import com.yammobots.holidaytestapp.common.BaseFragment
import com.yammobots.holidaytestapp.common.Pageable
import com.yammobots.holidaytestapp.model.PhotoModel
import com.yammobots.holidaytestapp.model.base.Resource
import com.yammobots.holidaytestapp.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * Created by kaungkhantsoe on 13/06/2020.
 **/

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    @Inject
    lateinit var requestManager: RequestManager

    private val viewModel by lazy {
        ViewModelProvider(this,viewModelProviderFactory).get(HomeViewModel::class.java)
    }

    private val adapter by lazy {
        HomeAdapter(requestManager)
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_home
    }

    override fun setUpContents(savedInstanceState: Bundle?) {

//        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(HomeViewModel::class.java)
//        adapter = HomeAdapter(requestManager)

        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(mContext,RecyclerView.VERTICAL,false)
        recycler.adapter = adapter

        subscribePhotos()
    }

    private fun subscribePhotos() {
        adapter.clear()

        viewModel.observePhotos()
            .observe(this, Observer { resource ->
                when (resource.status) {
                    Resource.Status.ERROR -> {
                        adapter.clearFooter()
                        showToastMsg(resource.message)
                    }

                    Resource.Status.LOADING -> {
                        adapter.showLoading()
                    }

                    Resource.Status.SUCCESS -> {
                        adapter.clearFooter()
                        adapter.add(resource.data.toList())
                    }
                }
            })
    }
}