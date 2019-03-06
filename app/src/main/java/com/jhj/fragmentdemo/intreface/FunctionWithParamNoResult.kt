package com.jhj.fragmentdemo.intreface

abstract class FunctionWithParamNoResult<PARAM>(functionName: String) : Function(functionName) {

    abstract fun function(param: PARAM)

}