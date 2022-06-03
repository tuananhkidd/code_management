package com.base.mvvmbasekotlin.ui.list_account

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.base.mvvmbasekotlin.R
import com.base.mvvmbasekotlin.base.BaseFragment
import com.base.mvvmbasekotlin.utils.ACTIVE
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : BaseFragment() {

    private val viewModel: AccountViewModel by viewModels()

    override fun backFromAddFragment() {

    }

    override val layoutId: Int
        get() = R.layout.fragment_account

    override fun initView() {

    }

    override fun initData() {
        arguments?.let {
            if(it.containsKey(KEY_STATUS)){
                val status = it.getInt(KEY_STATUS, ACTIVE)
                viewModel.status = status
                viewModel.getListAccount()
            }
        }
    }

    override fun initListener() {
        refresh.setOnRefreshListener {
            viewModel.getListAccount()
        }
        viewModel.listAccounts.observe(this){
            handleLoadMoreResponse(it)
        }
    }

    override fun getListResponse(data: List<*>?, isRefresh: Boolean, canLoadmore: Boolean) {
        if(isRefresh){

        }else{

        }


    }

    override fun backPressed(): Boolean {
        return false
    }

    companion object {
        fun newInstance(status: Int): AccountFragment {
            return AccountFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_STATUS, status)
                }
            }
        }

        private const val KEY_STATUS = "KEY_STATUS"
    }

    override fun showLoading() {
        refresh.isRefreshing = true
    }

    override fun hideLoading() {
        refresh.isRefreshing = false
    }

}