package com.base.mvvmbasekotlin.ui.list_account

import androidx.fragment.app.viewModels
import com.base.mvvmbasekotlin.R
import com.base.mvvmbasekotlin.base.BaseFragment

class AccountFragment : BaseFragment() {

    companion object {
        fun newInstance() = AccountFragment()
    }

    private val viewModel: AccountViewModel by viewModels()

    override fun backFromAddFragment() {
        
    }

    override val layoutId: Int
        get() = R.layout.fragment_account

    override fun initView() {
        
    }

    override fun initData() {
        
    }

    override fun initListener() {
        
    }

    override fun backPressed(): Boolean {
        return false
    }
}