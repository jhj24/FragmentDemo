package com.jhj.fragmentdemo.intreface

abstract class FunctionWithParamNoResult(functionName: String) : Function(functionName) {

    abstract fun<PARAM> function(param: PARAM)

}