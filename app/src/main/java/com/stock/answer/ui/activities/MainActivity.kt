package com.stock.answer.ui.activities

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.stock.answer.R
import com.stock.answer.base.BaseActivity
import com.stock.answer.beans.TabEntity
import com.stock.answer.ui.fragments.DataFragment
import com.stock.answer.ui.fragments.KnowledgeFragment
import com.stock.answer.ui.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val mTitles = arrayOf("首页", "知识", "资讯")

    //为选中图标
    private val mIconSelectIds = intArrayOf(R.mipmap.home, R.mipmap.stock, R.mipmap.news)

    //选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.un_home, R.mipmap.un_stock, R.mipmap.un_news)
    private val mTabEntities = ArrayList<CustomTabEntity>()
    private var mHomeFragment: HomeFragment? = null
    private var mKnowledgeFragment: KnowledgeFragment? = null
    private var mDataFragment: DataFragment? = null
    private var mIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initTab()
        tab_layout.currentTab = mIndex
        switchFragment(mIndex)
    }

    private fun initView() {
        val intent = intent
        mIndex = intent.getIntExtra("index", 0)
    }


    /***
     * 初始化底部菜单
     */
    private fun initTab() {
        (mTitles.indices).mapTo(mTabEntities) {
            TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it])
        }
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {
            }

        })

    }

    private fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (position) {
            0
            -> {
                mHomeFragment?.let {
                    transaction.show(it)
                } ?: HomeFragment.newInstance().let {
                    mHomeFragment = it
                    transaction.add(R.id.fl_container, it, "home")
                }
            }
            1
            -> {
                mKnowledgeFragment?.let {
                    transaction.show(it)
                } ?: KnowledgeFragment.newInstance().let {
                    mKnowledgeFragment = it
                    transaction.add(R.id.fl_container, it, "news")
                }
            }
            2
            -> {
                mDataFragment?.let {
                    transaction.show(it)
                } ?: DataFragment.newInstance().let {
                    mDataFragment = it
                    transaction.add(R.id.fl_container, it, "news")
                }
            }
        }

        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()

    }

    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mKnowledgeFragment?.let { transaction.hide(it) }
        mDataFragment?.let { transaction.hide(it) }
    }

    private var mExitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}