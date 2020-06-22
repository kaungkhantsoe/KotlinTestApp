package com.yammobots.holidaytestapp.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.yammobots.holidaytestapp.R
import com.yammobots.holidaytestapp.common.BaseActivity
import com.yammobots.holidaytestapp.model.PhotoModel
import com.yammobots.holidaytestapp.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

/**
 * Created by kaungkhantsoe on 18/06/2020.
 **/


class DetailActivity : BaseActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private val viewModel by lazy {
        ViewModelProvider(this,viewModelProviderFactory).get(DetailViewModel::class.java)
    }

    companion object {

        val IE_MODEL = "IE_MODEL"

        fun getIntent(context: Context, photoModel: PhotoModel) : Intent {
            return Intent(context,DetailActivity::class.java).apply {
                putExtra(IE_MODEL,photoModel)
            }
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_detail
    }

    override fun setUpContents(savedInstanceState: Bundle?) {
        setupToolbarColored(true)
        setupToolbarText("Detail")

        init()
    }

    private fun init() {

        viewModel.photoModel = intent.getSerializableExtra(IE_MODEL) as PhotoModel

        tv_album_id.setMyanmarText(viewModel.photoModel.albumId.toString())
        tv_id.setMyanmarText(viewModel.photoModel.id.toString())
        tv_title.setMyanmarText(viewModel.photoModel.title)

    }

}