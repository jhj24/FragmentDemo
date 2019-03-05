package com.jhj.fragmentdemo.intreface

object FunctionManager {


    private val mFunctionNoParamNoResult: HashMap<String, FunctionNoParamNoResult> = hashMapOf()
    private val mFunctionNoParamWithResult: HashMap<String, FunctionNoParamWithResult<*>> = hashMapOf()
    private val mFunctionWithParamNoResult: HashMap<String, FunctionWithParamNoResult<*>> = hashMapOf()


    fun addFunction(function: FunctionNoParamNoResult): FunctionManager {
        mFunctionNoParamNoResult.put(function.mFunctionName, function)
        return this;
    }

    fun <Result> addFunction(function: FunctionNoParamWithResult<Result>): FunctionManager {
        mFunctionNoParamWithResult.put(function.mFunctionName, function)
        return this;
    }

    fun <PARAM> addFunction(function: FunctionWithParamNoResult<PARAM>): FunctionManager {
        mFunctionWithParamNoResult.put(function.mFunctionName, function)
        return this
    }

    fun invokeFunction(functionName: String): FunctionManager {
        if (mFunctionNoParamNoResult.containsKey(functionName)) {
            val function = mFunctionNoParamNoResult[functionName]
            function?.function()
        }
        return this;
    }


    fun <RESULT> invokeFunction(functionName: String, clazz: Class<RESULT>?): RESULT? {
        if (mFunctionNoParamWithResult.containsKey(functionName)) {
            val function = mFunctionNoParamWithResult[functionName]
            if (function != null) {
                if (clazz != null) {
                    return clazz.cast(function.function())
                } else {
                    return function.function() as RESULT?
                }
            } else {
                throw Exception()
            }
        }
        return null
    }

    fun <PARAM> invokeFunction(functionName: String, param: PARAM) {
        if (mFunctionWithParamNoResult.containsKey(functionName)) {
            val function = mFunctionWithParamNoResult[functionName]
            function?.function(param)
        }
    }


}