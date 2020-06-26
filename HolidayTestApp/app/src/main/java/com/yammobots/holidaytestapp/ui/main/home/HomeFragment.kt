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
import com.yammobots.holidaytestapp.util.SmartScrollListener
import com.yammobots.holidaytestapp.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * Created by kaungkhantsoe on 13/06/2020.
 **/

class HomeFragment : BaseFragment(), SmartScrollListener.OnSmartScrollListener {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    @Inject
    lateinit var requestManager: RequestManager

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelProviderFactory).get(HomeViewModel::class.java)
    }

    private val adapter by lazy {
        HomeAdapter(requestManager)
    }

    private val smartScrollListener by lazy {
        SmartScrollListener(this)
    }

    private var albumId = 1

    override fun getLayoutResource(): Int {
        return R.layout.fragment_home
    }

    override fun setUpContents(savedInstanceState: Bundle?) {

        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        recycler.adapter = adapter
        recycler.addOnScrollListener(smartScrollListener)

        viewModel.albumId = albumId

        subscribePhotos()
    }

    private fun subscribePhotos() {
        if (albumId == 1)
            adapter.clear()

        viewModel.observePhotos()
            .observe(this, Observer { resource ->
                when (resource.status) {

                    ERROR -> {
                        adapter.clearFooter()
                        showToastMsg(resource.message)
                    }

                    LOADING -> {
                        if (albumId == 1)
                            adapter.showLoading()
                    }

                    SUCCESS -> {
                        adapter.clearFooter()
                        adapter.submitList(
                            resource.data.toList(),
                            HomeDiffUtil(adapter.itemsList, resource.data)
                        )
//                        adapter.add(resource.data.toList())
                    }
                }
            })
    }

    override fun onListEndReach() {
        albumId++
        viewModel.albumId = albumId
        subscribePhotos()
    }
}