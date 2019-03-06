package com.jhj.fragmentdemo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jhj.fragmentdemo.R
import com.jhj.fragmentdemo.intreface.FunctionManager
import kotlinx.android.synthetic.main.fragment_one.*

open class FragmentFour : BaseFragment() {

    companion object {
        val INTERFACE: String = this::class.java.name
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            val a = FunctionManager.invokeFunction(INTERFACE, "222", String::class.java)
            Log.w("xxx", a)
        }
    }
}