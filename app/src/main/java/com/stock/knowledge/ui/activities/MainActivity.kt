package com.stock.knowledge.ui.activities

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.stock.knowledge.R
import com.stock.knowledge.base.BaseActivity
import com.stock.knowledge.base.TabEntity
import com.stock.knowledge.ui.fragments.DataFragment
import com.stock.knowledge.ui.fragments.StockFragment
import com.stock.knowledge.ui.fragments.HomeFragment
import com.stock.knowledge.ui.fragments.MyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val mTitles = arrayOf("首页", "市场", "资料", "我的")

    //为选中图标
    private val mIconSelectIds = intArrayOf(R.mipmap.home, R.mipmap.stock, R.mipmap.news, R.mipmap.my)

    //选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.un_home, R.mipmap.un_stock, R.mipmap.un_news, R.mipmap.un_my)
    private val mTabEntities = ArrayList<CustomTabEntity>()
    private var mHomeFragment: HomeFragment? = null
    private var mStockFragment: StockFragment? = null
    private var mDataFragment: DataFragment? = null
    private var mMyFragment: MyFragment? = null
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
                tv_title.text = mTitles[position]
            }
            1
            -> {
                mStockFragment?.let {
                    transaction.show(it)
                } ?: StockFragment.newInstance().let {
                    mStockFragment = it
                    transaction.add(R.id.fl_container, it, "news")
                }
                tv_title.text = mTitles[position]
            }
            2
            -> {
                mDataFragment?.let {
                    transaction.show(it)
                } ?: DataFragment.newInstance().let {
                    mDataFragment = it
                    transaction.add(R.id.fl_container, it, "news")
                }
                tv_title.text = mTitles[position]
            }
            3
            -> {
                mMyFragment?.let {
                    transaction.show(it)
                } ?: MyFragment.newInstance().let {
                    mMyFragment = it
                    transaction.add(R.id.fl_container, it, "my")
                }
                tv_title.text = mTitles[position]
            }
        }

        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()

    }

    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mStockFragment?.let { transaction.hide(it) }
        mDataFragment?.let { transaction.hide(it) }
        mMyFragment?.let { transaction.hide(it) }
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