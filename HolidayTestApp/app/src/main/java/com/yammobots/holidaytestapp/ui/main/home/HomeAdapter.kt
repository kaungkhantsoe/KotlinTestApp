package com.yammobots.holidaytestapp.ui.main.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.bumptech.glide.RequestManager
import com.yammobots.holidaytestapp.R
import com.yammobots.holidaytestapp.common.BaseAdapter
import com.yammobots.holidaytestapp.model.PhotoModel
import com.yammobots.holidaytestapp.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_photo.view.*

/**
 * Created by kaungkhantsoe on 18/06/2020.
 **/

class HomeAdapter(var requestManager: RequestManager) : BaseAdapter() {


    override fun onCreateCustomHeaderViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder? {
        return null
    }

    override fun onBindCustomHeaderViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

    }

    override fun onCreateCustomViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_photo,parent,false)
        return ViewHolder(view)
    }

    override fun onBindCustomViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as ViewHolder).bindView(itemsList[position] as PhotoModel)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val context : Context = itemView.context

        fun bindView(model : PhotoModel) {

            requestManager.load("https://i.ytimg.com/vi/PPNMBYcjYXE/maxresdefault.jpg")
                .into(itemView.iv_image)

            itemView.tv_title.setMyanmarText(model.title)

            itemView.setOnClickListener {
                context.startActivity(DetailActivity.getIntent(context,model))
            }
        }
    }

}