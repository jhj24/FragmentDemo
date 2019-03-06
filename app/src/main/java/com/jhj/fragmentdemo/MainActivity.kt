package com.jhj.fragmentdemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jhj.fragmentdemo.fragment.*
import com.jhj.fragmentdemo.intreface.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list = listOf(
            FragmentOne(),
            FragmentTwo(),
            FragmentThree(),
            FragmentFour()
        )
        viewPager.adapter = MyAdapter(supportFragmentManager, list)


    }


    class MyAdapter(fm: FragmentManager, val list: List<Fragment>) : FragmentPagerAdapter(fm) {
        override fun getItem(p0: Int): Fragment {
            return list[p0]
        }

        override fun getCount(): Int {
            return list.size
        }

    }

    fun setFunctionForFragment(tag: String) {
        val fragment = supportFragmentManager.findFragmentByTag(tag)
        if (fragment is BaseFragment) {

            FunctionManager
                .addFunction(object : FunctionNoParamNoResult(FragmentOne.INTERFACE) {
                    override fun function() {
                        toast("成功调用无参数无返回值接口")
                    }
                })
                .addFunction(object : FunctionNoParamWithResult<String>(FragmentTwo.INTERFACE) {
                    override fun function(): String {
                        toast("成功调用无参数有返回值接口")
                        return "111"
                    }
                })
                .addFunction(object : FunctionWithParamNoResult<String>(FragmentThree.INTERFACE) {
                    override fun function(param: String) {
                        toast("成功调用有参无返回值接口")
                    }
                })
                .addFunction(object : FunctionWithParamWithResult<String, String>(FragmentFour.INTERFACE) {
                    override fun function(param: String): String {
                        toast("成功调用有参有返回值接口")
                        return param
                    }

                })

        }
    }

    fun toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}



