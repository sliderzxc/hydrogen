package com.sliderzxc.hydrogen.requests.get

import com.sliderzxc.hydrogen.Hydrogen
import com.sliderzxc.hydrogen.HydrogenDsl
import com.sliderzxc.hydrogen.result.HydrogenResult

@HydrogenDsl
inline fun <reified T : Any> Hydrogen.get(block: HydrogenGetRequestBuilder.() -> Unit): HydrogenResult<T> {
    return HydrogenGetRequestBuilder().apply(block).build().execute<T>()
}