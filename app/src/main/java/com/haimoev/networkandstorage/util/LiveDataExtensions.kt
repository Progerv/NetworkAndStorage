package com.haimoev.networkandstorage.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> LiveData<T>.doOnChange(owner: LifecycleOwner, f: (T) -> Unit) {
    observe(owner, {
        f(it)
    })
}