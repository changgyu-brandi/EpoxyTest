package com.changgyu.epoxytest

import android.util.Log
import com.google.gson.Gson
import java.util.*


fun<T: Any> getStringToClass(str: String, `class`: Class<T>): T{
    val result = Gson().fromJson<T>(str, `class`)
    return result
}
