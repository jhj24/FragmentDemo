package com.jhj.fragmentdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jhj.fragmentdemo.R
import com.jhj.fragmentdemo.intreface.FunctionManager
import kotlinx.android.synthetic.main.fragment_one.*

open class FragmentOne : BaseFragment() {

    companion object {
        val INTERFACE: String = this::class.java.name
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.text = "Fragment与Activity之间通信\n无参无返回值接口回调"
        button.setOnClickListener {
            FunctionManager.invokeFunction(INTERFACE)
        }
    }


}