package com.jhj.fragmentdemo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jhj.fragmentdemo.R
import com.jhj.fragmentdemo.intreface.FunctionManager
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentThree : Fragment() {

    companion object {
        val INTERFACE = this::class.java.name
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.text = "Fragment与Activity之间通信\n有参无返回值接口回调"
        button.setOnClickListener {
            FunctionManager.invokeFunction(INTERFACE,"111")
        }
    }
}