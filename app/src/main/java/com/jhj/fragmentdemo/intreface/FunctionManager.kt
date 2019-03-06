package com.jhj.fragmentdemo.intreface

object FunctionManager {


    private val mFunctionNoParamNoResult: HashMap<String, FunctionNoParamNoResult> = hashMapOf()
    private val mFunctionNoParamWithResult: HashMap<String, FunctionNoParamWithResult<*>> = hashMapOf()
    private val mFunctionWithParamNoResult: HashMap<String, FunctionWithParamNoResult<*>> = hashMapOf()
    private val mFunctionWithParamWithResult: HashMap<String, FunctionWithParamWithResult<*, *>> = hashMapOf()


    fun addFunction(function: FunctionNoParamNoResult): FunctionManager {
        mFunctionNoParamNoResult.put(function.mFunctionName, function)
        return this;
    }

    fun <RESULT> addFunction(function: FunctionNoParamWithResult<RESULT>): FunctionManager {
        mFunctionNoParamWithResult.put(function.mFunctionName, function)
        return this;
    }

    fun <PARAM> addFunction(function: FunctionWithParamNoResult<PARAM>): FunctionManager {
        mFunctionWithParamNoResult.put(function.mFunctionName, function)
        return this
    }

    fun <PARAM, RESULT> addFunction(function: FunctionWithParamWithResult<PARAM, RESULT>): FunctionManager {
        mFunctionWithParamWithResult.put(function.mFunctionName, function)
        return this;
    }

    fun invokeFunction(functionName: String): FunctionManager {
        if (mFunctionNoParamNoResult.containsKey(functionName)) {
            val function = mFunctionNoParamNoResult[functionName] ?: throw NullPointerException()
            function.function()
        }
        return this;
    }


    fun <RESULT> invokeFunction(functionName: String, clazz: Class<RESULT>?): RESULT? {
        if (mFunctionNoParamWithResult.containsKey(functionName)) {
            val function = mFunctionNoParamWithResult[functionName] ?: throw NullPointerException()
            if (clazz != null) {
                return clazz.cast(function.function())
            } else {
                try {
                    return function.function() as RESULT?
                } catch (e: ClassCastException) {
                    e.printStackTrace()
                }
            }
        }
        return null
    }

    fun <PARAM> invokeFunction(functionName: String, param: PARAM) {
        if (mFunctionWithParamNoResult.containsKey(functionName)) {
            try {
                val function = mFunctionWithParamNoResult[functionName] ?: throw NullPointerException()
                (function as FunctionWithParamNoResult<PARAM>).function(param)
            } catch (e: ClassCastException) {
                e.printStackTrace()
            }
        }
    }

    fun <PARAM, RESULT> invokeFunction(functionName: String, param: PARAM, clazz: Class<RESULT>?): RESULT? {
        if (mFunctionWithParamWithResult.containsKey(functionName)) {
            val function = mFunctionWithParamWithResult[functionName] ?: throw NullPointerException()
            try {
                val resultFunction = function as FunctionWithParamWithResult<PARAM, RESULT>
                if (clazz != null) {
                    return clazz.cast(resultFunction.function(param))
                } else {
                    return resultFunction.function(param)
                }
            } catch (e: ClassCastException) {
                e.printStackTrace()
            }
        }
        return null
    }


}