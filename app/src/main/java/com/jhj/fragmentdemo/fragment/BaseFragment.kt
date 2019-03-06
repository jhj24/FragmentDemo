package com.jhj.fragmentdemo.fragment

import android.content.Context
import android.support.v4.app.Fragment
import com.jhj.fragmentdemo.MainActivity

open class BaseFragment : Fragment() {



    private var mBaseActivity: MainActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainActivity) {
            mBaseActivity = context;
            mBaseActivity?.setFunctionForFragment(tag ?: "")
        }
    }
}
