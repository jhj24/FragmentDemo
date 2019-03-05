package com.jhj.fragmentdemo.intreface

abstract class FunctionWithParamWithResult<PARAM, RESULT>(functionName: String) : Function(functionName) {

    abstract fun function(param: PARAM): RESULT

}