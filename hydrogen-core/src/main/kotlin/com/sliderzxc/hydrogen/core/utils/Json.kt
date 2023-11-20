package com.sliderzxc.hydrogen.core.utils

import com.google.gson.Gson

inline fun <reified T> String.toObject(): T = Gson().fromJson(this, T::class.java)