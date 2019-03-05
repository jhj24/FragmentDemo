package com.jhj.fragmentdemo

import android.content.Context
import android.support.v4.app.Fragment
import com.jhj.fragmentdemo.intreface.FunctionManager

open class BaseFragment : Fragment() {

    var functionManager: FunctionManager? = null


    private var mBaseActivity: MainActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainActivity) {
            mBaseActivity = context;
            mBaseActivity?.setFunctionForFragment(tag ?: "")
        }
    }
}
