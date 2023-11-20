package com.sliderzxc.hydrogen.core.result

import com.sliderzxc.hydrogen.core.exception.HydrogenException

sealed interface HydrogenResult<out T> {
    data class Success<out T>(val result: T) : HydrogenResult<T>
    data class Error(val exception: HydrogenException) : HydrogenResult<Nothing>
}