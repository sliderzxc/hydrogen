package com.sliderzxc.hydrogen.result

import com.sliderzxc.hydrogen.exception.HydrogenException

sealed interface HydrogenResult {
    data class Success<T>(val result: T): HydrogenResult

    data class Error(val exception: HydrogenException): HydrogenResult
}