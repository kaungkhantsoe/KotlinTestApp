package com.yammobots.holidaytestapp.ui.main

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.yammobots.holidaytestapp.R
import com.yammobots.holidaytestapp.common.BaseActivity
import com.yammobots.holidaytestapp.ui.main.dining.DiningFragment
import com.yammobots.holidaytestapp.ui.main.home.HomeFragment
import com.yammobots.holidaytestapp.ui.main.posts.PostsFragment
import com.yammobots.holidaytestapp.ui.main.users.UsersFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainDelegate {

    private val HOME_FRAGMENT = "home"

    private val USERS_FRAGMENT = "users"

    private val POSTS_FRAGMENT = "posts"

    private val DINING_FRAGMENT = "dining"

    private lateinit var fragmentToShow : Fragment

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun setUpContents(savedInstanceState: Bundle?) {

        setupToolbar(false)

        setupBottomNavBar()
    }

    private fun setupBottomNavBar() {
        val homeItem = AHBottomNavigationItem("Home",R.drawable.nav_home)
        val usersItem = AHBottomNavigationItem("Users",R.drawable.nav_person)
        val postsItem = AHBottomNavigationItem("Posts",R.drawable.nav_post)
        val diningItem = AHBottomNavigationItem("Posts",R.drawable.nav_dining)

        bottom_navigation.addItem(homeItem)
        bottom_navigation.addItem(usersItem)
        bottom_navigation.addItem(postsItem)
        bottom_navigation.addItem(diningItem)

        // Change colors
        bottom_navigation.accentColor = Color.parseColor("#ffffff")
        bottom_navigation.inactiveColor = Color.parseColor("#bcbbbb")

        // Enable the translation inside the CoordinatorLayout
        bottom_navigation.isBehaviorTranslationEnabled = true

        bottom_navigation.isTranslucentNavigationEnabled = true

        // Set background color
        bottom_navigation.defaultBackgroundColor = resources.getColor(R.color.colorPrimaryDark)

        // Set listeners
        bottom_navigation.setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener { position: Int, wasSelected: Boolean ->
            when (position) {
                0 -> {
                    displayView(HOME_FRAGMENT)
                    return@OnTabSelectedListener true
                }
                1 -> {
                    displayView(USERS_FRAGMENT)
                    return@OnTabSelectedListener true
                }
                2 -> {
                    displayView(POSTS_FRAGMENT)
                    return@OnTabSelectedListener true
                }
                3 -> {
                    displayView(DINING_FRAGMENT)
                    return@OnTabSelectedListener true
                }
                else -> return@OnTabSelectedListener true
            }
        })

        bottom_navigation.currentItem = 0

    }

    fun displayView(frag : String) {

        when(frag) {
            HOME_FRAGMENT -> {
                fragmentToShow = HomeFragment()
            }

            USERS_FRAGMENT -> {
                fragmentToShow = UsersFragment()
            }

            POSTS_FRAGMENT -> {
                fragmentToShow = PostsFragment()
            }

            DINING_FRAGMENT -> {
                fragmentToShow = DiningFragment()
            }

        }

        if (this::fragmentToShow.isInitialized) {

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container,fragmentToShow).commit()

        }


    }



}