package com.jhj.fragmentdemo.intreface

abstract class FunctionNoParamWithResult(functionName: String) : Function(functionName) {

    abstract fun<RESULT> function(): RESULT

}