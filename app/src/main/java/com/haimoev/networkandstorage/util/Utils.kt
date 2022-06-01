package com.haimoev.networkandstorage.util

fun Double.format(digits: Int) = String.Companion.format(
    java.util.Locale.GERMAN,
    "%#,.${digits}f",
    this
)