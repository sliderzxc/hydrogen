package com.sliderzxc.hydrogen.result

import com.sliderzxc.hydrogen.exception.HydrogenException

sealed interface HydrogenResult<out T> {
    data class Success<out T>(val result: T) : HydrogenResult<T>
    data class Error(val exception: HydrogenException) : HydrogenResult<Nothing>
}