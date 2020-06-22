package com.yammobots.holidaytestapp.ui.main.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.yammobots.holidaytestapp.R
import com.yammobots.holidaytestapp.common.BaseFragment
import com.yammobots.holidaytestapp.model.base.Resource.Status.*
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

        viewModel.albumId = 2

        subscribePhotos()
    }

    private fun subscribePhotos() {
        adapter.clear()

        viewModel.observePhotos()
            .observe(this, Observer { resource ->
                when (resource.status) {
                    ERROR -> {
                        adapter.clearFooter()
                        showToastMsg(resource.message)
                    }

                    LOADING -> {
                        adapter.showLoading()
                    }

                    SUCCESS -> {
                        adapter.clearFooter()
                        adapter.add(resource.data.toList())
                    }
                }
            })
    }
}