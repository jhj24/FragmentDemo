package com.jhj.fragmentdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jhj.fragmentdemo.intreface.FunctionManager
import com.jhj.fragmentdemo.intreface.FunctionNoParamNoResult
import com.jhj.fragmentdemo.intreface.FunctionNoParamWithResult

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
                        return ""
                    }
                })
        }
    }

    fun toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}



