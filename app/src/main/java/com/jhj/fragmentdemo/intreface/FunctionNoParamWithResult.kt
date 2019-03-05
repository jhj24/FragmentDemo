package com.jhj.fragmentdemo.intreface

abstract class FunctionNoParamWithResult<RESUTL>(functionName: String) : Function(functionName) {

    abstract fun function(): RESUTL

}