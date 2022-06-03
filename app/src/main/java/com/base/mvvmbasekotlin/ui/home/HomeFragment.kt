package com.base.mvvmbasekotlin.ui.home

import com.base.mvvmbasekotlin.R
import com.base.mvvmbasekotlin.base.BaseFragment
import com.base.mvvmbasekotlin.base.custom.BaseFragmentStatePagerAdapter
import com.base.mvvmbasekotlin.base.entity.BaseFragmentPagerModel
import com.base.mvvmbasekotlin.ui.list_account.AccountFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.home_fragment.*

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var viewModel: HomeViewModel
    private val listFragments = mutableListOf<BaseFragmentPagerModel>()

    override fun backFromAddFragment() {
        
    }

    override val layoutId: Int
        get() = R.layout.home_fragment

    override fun initView() {
        listFragments.add(
            BaseFragmentPagerModel(
                AccountFragment(),
                "TK chưa kich hoạt"
            )
        )

        listFragments.add(
            BaseFragmentPagerModel(
                AccountFragment(),
                "TK đã kich hoạt"
            )
        )

        pager.adapter = context?.let {
            BaseFragmentStatePagerAdapter(
                it, listFragments, this
            )
        }

        TabLayoutMediator(tab_layout, pager, false, false) { tab, position ->
            tab_layout.setupTabLayout(tab, listFragments[position])
        }.attach()

    }

    override fun initData() {
        
    }

    override fun initListener() {
        
    }

    override fun backPressed(): Boolean {

        return true
    }
}