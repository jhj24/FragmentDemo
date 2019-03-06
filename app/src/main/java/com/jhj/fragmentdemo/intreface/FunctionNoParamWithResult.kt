package com.jhj.fragmentdemo.intreface

abstract class FunctionNoParamWithResult<RESULT>(functionName: String) : Function(functionName) {

    abstract fun function(): RESULT

}