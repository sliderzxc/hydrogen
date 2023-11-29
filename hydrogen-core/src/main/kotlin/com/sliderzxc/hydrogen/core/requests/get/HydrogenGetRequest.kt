package com.sliderzxc.hydrogen.core.requests.get

import com.sliderzxc.hydrogen.core.Hydrogen
import com.sliderzxc.hydrogen.core.HydrogenDsl
import com.sliderzxc.hydrogen.core.result.HydrogenResult

@HydrogenDsl
inline fun <reified T : Any> Hydrogen.get(block: HydrogenGetRequestBuilder.() -> Unit): HydrogenResult<T> {
    return HydrogenGetRequestBuilder().apply(block).build().execute<T>(this.baseUrl)
}