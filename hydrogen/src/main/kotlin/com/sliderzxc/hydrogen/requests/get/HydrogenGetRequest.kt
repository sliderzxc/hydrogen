package com.sliderzxc.hydrogen.requests.get

import com.sliderzxc.hydrogen.Hydrogen
import com.sliderzxc.hydrogen.HydrogenDsl
import com.sliderzxc.hydrogen.requests.HydrogenRequestType
import okhttp3.internal.wait

@HydrogenDsl
inline fun <reified T : Any> Hydrogen.get(block: HydrogenGetRequestBuilder.() -> Unit): Result<T> {
    return HydrogenGetRequestBuilder().apply(block).build().execute<T>()
}