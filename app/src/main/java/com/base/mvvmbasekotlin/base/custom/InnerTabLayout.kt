package com.base.mvvmbasekotlin.base.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import com.base.mvvmbasekotlin.R
import com.base.mvvmbasekotlin.base.entity.BaseFragmentPagerModel
import com.google.android.material.tabs.TabLayout

class InnerTabLayout(context: Context, attrs: AttributeSet? = null): TabLayout(context, attrs), TabLayout.OnTabSelectedListener {

    init {
        addOnTabSelectedListener(this)
    }

    override fun newTab(): Tab {
        val tab = super.newTab()
        tab.setCustomView(R.layout.layout_inner_tab)
        return tab
    }

    override fun onTabSelected(tab: Tab?) {
//        tab?.customView?.findViewById<TextView>(R.id.tv_tab_name)?.typeface = context.resources.getFont(R.font.noto_sans_cjk_jp_bold)
    }

    override fun onTabUnselected(tab: Tab?) {
//        tab?.customView?.findViewById<TextView>(R.id.tv_tab_name)?.typeface = context.resources.getFont(R.font.noto_sans_cjk_jp_medium)
    }

    override fun onTabReselected(tab: Tab?) {
        // nothing to do
    }

    fun setupTabLayout(tab: Tab, item: BaseFragmentPagerModel) {
        tab.customView?.findViewById<TextView>(R.id.tv_tab_name)?.text = item.title
    }
}